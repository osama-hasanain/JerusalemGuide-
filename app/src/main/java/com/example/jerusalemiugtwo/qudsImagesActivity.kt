package com.example.jerusalemiugtwo

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.jerusalemiugtwo.Adapters.qudsImageAdapter
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_quds_images.*
import java.io.ByteArrayOutputStream

class qudsImagesActivity : AppCompatActivity() ,qudsImageAdapter.imageClick,View.OnClickListener{
    var array = ArrayList<String>()
    var isOpen = false
    lateinit var bitmap: Bitmap
    lateinit var mStorageRef : StorageReference
    lateinit var storageRef:StorageReference
    var TAG = "qudsImagesActivity"
    lateinit var progressDialog:ProgressDialog
    var firestore: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quds_images)

        back_but.setOnClickListener {
            finish()
        }
        init()
        qudsImages_img_cancel.setOnClickListener(this)
        image_uploadImg.setOnClickListener(this)
    }
    private fun init(){
        mStorageRef = FirebaseStorage.getInstance().reference
        storageRef = mStorageRef.child("qudsImages")
        progressDialog = ProgressDialog(this)
        firestore = FirebaseFirestore.getInstance()
    }

    override fun onStart() {
        super.onStart()
        getImages()
    }

    override fun onRestart() {
        super.onRestart()
        getImages()
    }
    private fun getImages() {
        firestore!!.collection("qudsImages")
            .get()
            .addOnSuccessListener { it->
                array.clear()
                for (item in it){
                    array.add(item.get("url").toString())
                }
                if (array.size>0) {
                    var adapter = qudsImageAdapter(this, array, this)
                    qudsImages_recycler.layoutManager = GridLayoutManager(this, 2)
                    qudsImages_recycler.adapter = adapter
                }else{
                    qudsImages_txt_noImages.visibility = View.VISIBLE
                    qudsImages_recycler.visibility = View.GONE
                }

            }

    }
    override fun imageClicked(position: Int) {
        isOpen = !isOpen
        Glide.with(this).load(array[position]).into(qudsImages_img)
        qudsImages_recycler.visibility = View.GONE
        qudsImages_img.visibility = View.VISIBLE
        qudsImages_img_cancel.visibility = View.VISIBLE
    }
    override fun onClick(v: View?) {
        when(v){
            qudsImages_img_cancel ->{
                isOpen = !isOpen
                qudsImages_recycler.visibility = View.VISIBLE
                qudsImages_img.visibility = View.GONE
                qudsImages_img_cancel.visibility = View.GONE
            }
            image_uploadImg ->{
                getImage()
            }
        }
    }

    private fun getImage(){
        ImagePicker.with(this)
            .crop()	    			//Crop image(Optional), Check Customization for more option
            .compress(1024)			//Final image size will be less than 1 MB(Optional)
            .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
            .start()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
           var uri = data?.data!!

            bitmap = MediaStore.Images.Media.getBitmap(baseContext.contentResolver,uri)
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG,100,baos)
            val data = baos.toByteArray()

            progressDialog.setMessage("Image Loading ...")
            progressDialog.setCancelable(false)
            progressDialog.show()
            uploadImages(data)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
    private fun uploadImages(data:ByteArray){
        val childRef = storageRef.child(System.currentTimeMillis().toString())
        childRef.putBytes(data)
            .addOnSuccessListener {
                childRef.downloadUrl
                    .addOnSuccessListener { url->
                    Log.e(TAG,"$TAG : $url")
                    uploadUrl(url.toString())
                    }
                    .addOnFailureListener { e->
                        Log.e(TAG,"$TAG ERROR : ${e.message}")
                        Toast.makeText(baseContext,"Error in Uploading",Toast.LENGTH_LONG).show()
                        progressDialog.dismiss()
                    }
            }
    }
    private fun uploadUrl(url:String){
        var map = HashMap<String,Any>()
        map.put("url",url)
        firestore!!.collection("qudsImages")
            .add(map)
            .addOnSuccessListener {
                Toast.makeText(baseContext,"Uploading is Success",Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
                onStart()
            }
            .addOnFailureListener {it->
                Toast.makeText(baseContext,"Error in Uploading",Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
            }
    }
}