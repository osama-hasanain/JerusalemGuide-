package com.example.jerusalemiugtwo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {
    var URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    var player:SimpleExoPlayer? = null
    var playerWhenReady = true
    var currentWindow:Int = 0
    var playPackPosition:Long = 0
    var TAG ="VideoPlayerActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
    }

    private fun initVideo(){
        player = ExoPlayerFactory.newSimpleInstance(this)
        videoPlayer_vdVw.player = player
        var uri = Uri.parse(URL)
        var dataSourceFactory:DataSource.Factory = DefaultDataSourceFactory(this,"exoplayer-codelab")
         var mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)

        player!!.playWhenReady = playerWhenReady
        player!!.seekTo(currentWindow,playPackPosition)
        player!!.prepare(mediaSource,false,false)
    }
    private fun releaseVideo(){
        if (player!=null){
            Log.e(TAG,"in NULL")
            playerWhenReady=player!!.playWhenReady
            playPackPosition=player!!.currentPosition
            currentWindow=player!!.currentWindowIndex
            player!!.release()
            videoPlayer_vdVw.player.release()
            player!!.stop()
            player = null
        }
    }
    override fun onStart() {
        super.onStart()
        initVideo()
    }
    override fun onResume() {
        super.onResume()
        if (player!=null)
            initVideo()
    }
    override fun onPause() {
        super.onPause()
        releaseVideo()
    }
    override fun onStop() {
        super.onStop()
        releaseVideo()
    }
}