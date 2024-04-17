package com.dicoding.belajarmatematika.tampilan

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.dicoding.belajarmatematika.R

class VideoOperasi : AppCompatActivity() {

    private  var myVideoView: VideoView? = null
    private  var myMediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_operasi)

        myVideoView = findViewById(R.id.myVideo)

        setUpVideoPlayer()
    }

    private fun setUpVideoPlayer() {

        if (myMediaController == null) {
            myMediaController = MediaController(this) // Menggunakan operator penugasan tunggal (=) bukan ganda (==)
            myMediaController!!.setAnchorView(myVideoView)
        }
            myVideoView!!.setMediaController(myMediaController)

            myVideoView!!.setVideoURI(
                Uri.parse("android.resource://"
                + packageName + "/" + R.raw.operasi_hitung)
            )

            myVideoView!!.requestFocus()

            myVideoView!!.pause()

            myVideoView!!.setOnCompletionListener {
                Toast.makeText(applicationContext, "Video Selesai", Toast.LENGTH_SHORT).show()
            }

            myVideoView!!.setOnErrorListener { mp, what, extra ->
                Toast.makeText(applicationContext, "An Error Occurced", Toast.LENGTH_SHORT).show()
                false
            }
    }
}