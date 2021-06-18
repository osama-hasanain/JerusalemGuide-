package com.example.jerusalemiugtwo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jerusalemiugtwo.MusicActivity
import com.example.jerusalemiugtwo.R
import com.example.jerusalemiugtwo.VideoPlayerActivity
import com.example.jerusalemiugtwo.qudsImagesActivity
import kotlinx.android.synthetic.main.fragment_multimedia.*
import kotlinx.android.synthetic.main.fragment_multimedia.view.*

class MultimediaFragment : Fragment() , View.OnClickListener {

    lateinit var root : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_multimedia, container, false)

        root.music_choice.setOnClickListener(this)
        root.image_choice.setOnClickListener(this)
        root.video_choice.setOnClickListener(this)

        return root
    }

    override fun onClick(v: View?) {
        when(v){
            root.music_choice ->{
                startActivity(Intent(activity!!,MusicActivity::class.java))
            }
            root.image_choice ->{
                startActivity(Intent(activity!!,qudsImagesActivity::class.java))
            }
            root.video_choice ->{
                startActivity(Intent(activity!!,VideoPlayerActivity::class.java))
            }
        }
    }
}