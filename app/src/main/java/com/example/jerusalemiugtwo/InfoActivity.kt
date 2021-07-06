package com.example.jerusalemiugtwo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.jerusalemiugtwo.RecycleViewInfo.CardInfo
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    var  title : String? = ""
    var  image : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        back_but.setOnClickListener {
            finish()
        }
        if (intent != null){
           var info = intent.getSerializableExtra("info") as CardInfo
            Glide.with(baseContext).load(info.img).into(image_info_activity)
            title_info_activity.text = info.title
            content_info.text = info.desc
        }
    }
}