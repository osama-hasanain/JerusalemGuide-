package com.example.jerusalemiugtwo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.jerusalemiugtwo.model.NewsItem
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.activity_news.view.*

class NewsActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var new : NewsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        init()
        setData()

        back_but.setOnClickListener {
            finish()
        }

        //new_img_back.setOnClickListener(this)
        new_txt_link.setOnClickListener(this)
    }

    fun init(){
      new = intent.getSerializableExtra("new") as NewsItem
    }

    fun setData(){
        Glide.with(this).load(new.img).into(new_img)
        new_title.text = new.title
        new_txt_date.text = new.date
        new_txt_details.text = new.desc
    }

    override fun onClick(v: View?) {
        when (v){
            back_but -> finish()
            new_txt_link -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(new.link)
                startActivity(intent)
            }
        }
    }

}