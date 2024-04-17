package com.dicoding.belajarmatematika.tampilan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.dicoding.belajarmatematika.R

class HasilKuis : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hasil_kuis)

        val hasil = findViewById<TextView>(R.id.hasil)
        val nilai = findViewById<TextView>(R.id.nilai)

        hasil.text = "Jawaban Benar : ${QuizPilgan.benar}\nJawaban Salah : ${QuizPilgan.salah}"
        nilai.text = QuizPilgan.hasil.toString()
    }

    fun ulangi(view: View) {
        finish()
        val i = Intent(applicationContext, QuizPilgan::class.java)
        startActivity(i)
    }
}