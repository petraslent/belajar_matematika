package com.dicoding.belajarmatematika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.dicoding.belajarmatematika.tampilan.QuizPilgan
import com.dicoding.belajarmatematika.tampilan.VideoOperasi
import com.dicoding.belajarmatematika.tampilan.VideoSistem

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveSistem: Button = findViewById(R.id.btn_move_sistem)
        btnMoveSistem.setOnClickListener(this)

        val btnMoveQuiz: Button = findViewById(R.id.btn_move_quiz)
        btnMoveQuiz.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, VideoOperasi::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_sistem -> {
                val moveIntent = Intent(this@MainActivity, VideoSistem::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_quiz -> {
                val moveIntent = Intent(this@MainActivity, QuizPilgan::class.java)
                startActivity(moveIntent)
            }
        }
    }
}