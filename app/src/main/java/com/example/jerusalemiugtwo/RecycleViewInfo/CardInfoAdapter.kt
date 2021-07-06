package com.example.jerusalemiugtwo.RecycleViewInfo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jerusalemiugtwo.InfoActivity
import com.example.jerusalemiugtwo.R
import kotlinx.android.synthetic.main.card_info.view.*

class CardInfoAdapter (
        val context: Context, val data: MutableList<CardInfo>,
        val click:onClick): RecyclerView.Adapter<CardInfoAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val titleR = item.text_info
        val imageInfo = item.image_info
        val card = item.card_Info
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflate = LayoutInflater.from(context).inflate(R.layout.card_info, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleR?.text = data[position].title
        Glide.with(context).load(data[position].img).into(holder.imageInfo)
        holder.card.setOnClickListener {
            click.onClickItem(holder.adapterPosition)
            var intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("info",data[position])
            context.startActivity(intent)
        }
    }



    interface onClick {
        fun onClickItem(position: Int)
    }

}