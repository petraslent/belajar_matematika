package com.dicoding.belajarmatematika.tampilan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.dicoding.belajarmatematika.R

class QuizPilgan : AppCompatActivity() {

    private lateinit var pertanyaan: TextView
    private lateinit var rg: RadioGroup
    private lateinit var PilihanA: RadioButton
    private lateinit var PilihanB: RadioButton
    private lateinit var PilihanC: RadioButton
    private lateinit var PilihanD: RadioButton
    private var nomor = 0
    companion object {
        var hasil = 0
        var benar = 0
        var salah = 0
    }

    private val pertanyaan_kuis = arrayOf(
        "1. Nina membeli 10 buku tulis dengan harga Rp 3.200,00 per buah. Berapa total yang harus Nina bayar?",
        "2. Sebuah mobil menempuh jarak 180 km dalam waktu 3 jam. Berapa kecepatan rata-rata mobil tersebut?",
        "3. Sebuah kolam renang memiliki volume 2.000 liter. Jika kolam tersebut diisi air dengan kecepatan 40 liter per menit, maka berapa lama waktu yang dibutuhkan untuk mengisi kolam renang tersebut hingga penuh?",
        "4. Sebuah lapangan berbentuk persegi panjang dengan panjang 20 meter dan lebar 12 meter. Jika lapangan tersebut ingin dipaving dengan biaya Rp 8.000,00 per meter persegi, maka berapa total biaya yang dibutuhkan?",
        "5. Sebuah helikopter terbang dengan ketinggian 8.500 meter. Jika helikopter tersebut mendarat dengan kecepatan 350 meter per menit, maka berapa lama waktu yang dibutuhkan untuk mendarat?"
    )

    private val pilihan_jawaban = arrayOf(
        "Rp 28.000", "Rp 30.000", "Rp 32.000", "Rp 34.000",
        "40 km/jam", "50 km/jam", "60 km/jam", "70 km/jam",
        "30 menit", "40 menit", "50 menit", "60 menit",
        "Rp 1.940.000", "Rp 1.920.000", "Rp 1.960.000", "Rp 1.910.000",
        "29,24 menit", "24,29 menit", "25,29 menit", "24,20 menit"
    )

    private val jawaban_benar = arrayOf(
        "Rp 32.000",
        "60 km/jam",
        "50 menit",
        "Rp 1.920.000",
        "24,29 menit"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_pilgan)

        pertanyaan = findViewById(R.id.pertanyaan)
        rg = findViewById(R.id.radio_group)
        PilihanA = findViewById(R.id.pilihanA)
        PilihanB = findViewById(R.id.pilihanB)
        PilihanC = findViewById(R.id.pilihanC)
        PilihanD = findViewById(R.id.pilihanD)

        pertanyaan.text = pertanyaan_kuis[nomor]
        PilihanA.text = pilihan_jawaban[nomor * 4]
        PilihanB.text = pilihan_jawaban[nomor * 4 + 1]
        PilihanC.text = pilihan_jawaban[nomor * 4 + 2]
        PilihanD.text = pilihan_jawaban[nomor * 4 + 3]

        rg.check(0)
        benar = 0
        salah = 0
    }

    fun next(view: View) {
        if (PilihanA.isChecked || PilihanB.isChecked || PilihanC.isChecked || PilihanD.isChecked) {
            val jawaban_user = findViewById<RadioButton>(rg.checkedRadioButtonId)
            val ambil_jawaban_user = jawaban_user.text.toString()
            rg.check(0)
            if (ambil_jawaban_user.equals(jawaban_benar[nomor], ignoreCase = true)) benar++
            else salah++
            nomor++
            if (nomor < pertanyaan_kuis.size) {
                pertanyaan.text = pertanyaan_kuis[nomor]
                PilihanA.text = pilihan_jawaban[nomor * 4]
                PilihanB.text = pilihan_jawaban[nomor * 4 + 1]
                PilihanC.text = pilihan_jawaban[nomor * 4 + 2]
                PilihanD.text = pilihan_jawaban[nomor * 4 + 3]
            } else {
                hasil = benar * 20
                val selesai = Intent(applicationContext, HasilKuis::class.java)
                startActivity(selesai)
            }
        } else {
            Toast.makeText(this, "Pilih Jawaban dulu", Toast.LENGTH_SHORT).show()
        }
    }
}