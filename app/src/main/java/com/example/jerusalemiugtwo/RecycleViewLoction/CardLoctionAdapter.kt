package com.example.jerusalemiugtwo.RecycleViewLoction

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jerusalemiugtwo.LoctionInfoActivity
import com.example.jerusalemiugtwo.R
import kotlinx.android.synthetic.main.card_loction.view.*

class CardLoctionAdapter(
        val context: Context, val data: MutableList<CardLoction>,
        val click:onClick): RecyclerView.Adapter<CardLoctionAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imgR = item.image_card
        val titleR = item.text_card
        val card = item.card_loction
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflate = LayoutInflater.from(context).inflate(R.layout.card_loction, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgR.setImageResource(data[position].image)
        holder.titleR?.text = data[position].title
        holder.card.setOnClickListener {
            click.onClickItem(holder.adapterPosition)
            var intent = Intent(context, LoctionInfoActivity::class.java)
            intent.putExtra("titleLoction",data[position].title)
            intent.putExtra("type",data[position].type)
            context.startActivity(intent)
        }
    }



    interface onClick {
        fun onClickItem(position: Int)
    }

}