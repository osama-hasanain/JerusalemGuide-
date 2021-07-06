package com.example.jerusalemiugtwo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jerusalemiugtwo.R
import com.example.jerusalemiugtwo.RecycleViewInfo.CardInfo
import com.example.jerusalemiugtwo.RecycleViewInfo.CardInfoAdapter
import com.example.jerusalemiugtwo.RecycleViewLoction.CardLoction
import com.example.jerusalemiugtwo.RecycleViewLoction.CardLoctionAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_information.view.*
import kotlinx.android.synthetic.main.fragment_loction.view.*

class InformationFragment : Fragment(),CardInfoAdapter.onClick {

    lateinit var firestore:FirebaseFirestore
    lateinit var data : ArrayList<CardInfo>
    lateinit var Adapter : CardInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_information, container, false)

        init()

        root.rvInformation.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true)
        root.rvInformation.setHasFixedSize(true)
        root.rvInformation.adapter=Adapter

        getDate()

        return root
    }

    private fun init(){
        firestore = FirebaseFirestore.getInstance()
        data = ArrayList()
        Adapter = CardInfoAdapter(activity!!.baseContext,data,this)
    }

    private fun getDate(){
        firestore.collection("Information")
            .get()
            .addOnSuccessListener { querySnapShot ->
                for(snapshot in querySnapShot){
                    var title = snapshot.get("title") as String
                    var img = snapshot.get("img") as String
                    var desc = snapshot.get("desc") as String
                    var info = CardInfo(snapshot.id,img,title,desc)
                    data.add(info)
                }
                Adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(activity!!.baseContext,"Error in get data",Toast.LENGTH_LONG).show()
            }
    }

    override fun onClickItem(position: Int) {
        //Toast.makeText(context,"Welcome to App",Toast.LENGTH_SHORT).show()
    }


}
