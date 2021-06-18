package com.example.jerusalemiugtwo

import android.app.Dialog
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_music.*
import kotlinx.android.synthetic.main.music_layout_dialog.*

class MusicActivity : AppCompatActivity() , View.OnClickListener {

    var player : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        back_but.setOnClickListener {
            finish()
        }


        music1.setOnClickListener(this)
        music2.setOnClickListener(this)
        music3.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
       when(v){
           music1 ->{
               runMusic("أنشودة قدسنا للمنشد نايف شهران ",R.raw.quds_nayef)
           }
           music2 ->{
               runMusic("أنشودة أنا ابن القدس ومن هون ",R.raw.quds_son)
           }
           music3 ->{
               runMusic("الأرض لنا و القدس لنا",R.raw.quds_our)
           }
       }
    }

    fun runMusic(title:String,music:Int){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.music_layout_dialog)
        dialog.music_dialog_title.text = title
        dialog.setCancelable(false)
        player = MediaPlayer.create(MusicActivity@this,music)
        player!!.start()
        dialog.music_dialog_play.setOnClickListener {
            player!!.start()
        }
        dialog.music_dialog_pause.setOnClickListener {
            player!!.pause()
        }
        dialog.music_dialog_close.setOnClickListener {
            player!!.release()
            player = null
            dialog.dismiss()
        }
        dialog.show()
    }
}