package com.example.jerusalemiugtwo.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jerusalemiugtwo.R
import kotlinx.android.synthetic.main.quds_image_item_layout.view.*

class qudsImageAdapter(var context: Context,var array:ArrayList<String>,var click: imageClick) : RecyclerView.Adapter<qudsImageAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.quds_image_item_layout,parent,false)
        return MyViewHolder(root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(array[position]).into(holder.img)
        holder.img.setOnClickListener {
            click.imageClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var img = itemView.qudsImages_item_img
    }

    interface imageClick{
        fun imageClicked(position: Int)
    }

}