package com.example.jerusalemiugtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jerusalemiugtwo.RecycleViewLoctionInfo.CardLoctionInfo
import com.example.jerusalemiugtwo.RecycleViewLoctionInfo.CardLoctionInfoAdapter
import com.example.jerusalemiugtwo.model.location
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_loction_info.*

class LoctionInfoActivity : AppCompatActivity(),CardLoctionInfoAdapter.onClick {

    var  address : String? = ""
    var type = 0
    lateinit var firestore : FirebaseFirestore
    lateinit var array : ArrayList<CardLoctionInfo>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loction_info)

        init()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getListLoctionInfo()
        back_but.setOnClickListener {
            finish()
        }
    }

    private fun init(){
        firestore = FirebaseFirestore.getInstance()
        address = intent.getStringExtra("titleLoction")
        type = intent.getIntExtra("type",0)
        array = ArrayList()
    }
    private fun getListLoctionInfo(){
        firestore.collection("Loction").whereEqualTo("type",type)
            .get()
            .addOnSuccessListener {
                for (query in it){
                    var data = query.toObject(CardLoctionInfo::class.java)
                    array.add(data)
                }
                setViewData()
            }
            .addOnFailureListener {
                Toast.makeText(baseContext,"Error in get Data",Toast.LENGTH_LONG).show()
            }
    }
    private fun setViewData(){
        var adapter = CardLoctionInfoAdapter(baseContext,array,this)
        rvLoctionInfo.layoutManager = LinearLayoutManager(this)
        rvLoctionInfo.adapter = adapter
    }

    override fun onClickItem(position: Int) {
        TODO("Not yet implemented")
    }


}
