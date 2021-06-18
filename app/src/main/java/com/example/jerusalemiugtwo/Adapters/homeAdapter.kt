package com.example.jerusalemiugtwo.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jerusalemiugtwo.NewsActivity
import com.example.jerusalemiugtwo.R
import com.example.jerusalemiugtwo.model.NewsItem
import kotlinx.android.synthetic.main.home_news_item_layout.view.*

class homeAdapter(var context:Activity,var array:ArrayList<NewsItem>):RecyclerView.Adapter<homeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var root = LayoutInflater.from(context).inflate(R.layout.home_news_item_layout,parent,false)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = array[position].title
        Glide.with(context).load(array[position].img).into(holder.img)

//        if (position%3==0)
//            holder.typeBackground.setCardBackgroundColor(Color.RED)
//        else if (position%2==0)
//            holder.typeBackground.setCardBackgroundColor(Color.BLUE)
//        else
//            holder.typeBackground.setCardBackgroundColor(Color.GREEN)

        holder.itemView.setOnClickListener {
            var intent = Intent(context,NewsActivity::class.java)
            intent.putExtra("new",array[position])
            context.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var card = itemView.news_item_card
        var img = itemView.news_item_img
        var title = itemView.news_item_title
//        var type = itemView.news_item_type
//        var typeBackground = itemView.news_item_type_background
    }
}