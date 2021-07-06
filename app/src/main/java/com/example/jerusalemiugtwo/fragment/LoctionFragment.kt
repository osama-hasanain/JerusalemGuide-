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
import com.example.jerusalemiugtwo.RecycleViewLoction.CardLoction
import com.example.jerusalemiugtwo.RecycleViewLoction.CardLoctionAdapter
import kotlinx.android.synthetic.main.fragment_loction.view.*

class LoctionFragment : Fragment(),CardLoctionAdapter.onClick{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_loction, container, false)

        val data = mutableListOf<CardLoction>()
        data.add(CardLoction(R.drawable.school,"مدارس تاريخية",2))
        data.add(CardLoction(R.drawable.mosquea,"مساجد",1))
        data.add(CardLoction(R.drawable.mosque,"القباب",4))
        data.add(CardLoction(R.drawable.gate,"بوابات الاقصى",3))
        data.add(CardLoction(R.drawable.minaret,"مآذن الأقصى",5))
        data.add(CardLoction(R.drawable.camera,"معالم اخرى",6))
        data.add(CardLoction(R.drawable.water,"أسبلة الأقصى",8))
        data.add(CardLoction(R.drawable.brick,"بوائك الأقصى",7))



        root.rvLoction.layoutManager = GridLayoutManager(activity,2)
        root.rvLoction.setHasFixedSize(true)

        val Adapter = CardLoctionAdapter(activity!!,data,this)
        root.rvLoction.adapter=Adapter


        return root
    }

    override fun onClickItem(position: Int) {
        //Toast.makeText(context,"Welcome to App", Toast.LENGTH_SHORT).show()
    }


}