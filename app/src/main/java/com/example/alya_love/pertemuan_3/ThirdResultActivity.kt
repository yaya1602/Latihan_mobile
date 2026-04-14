package com.example.alya_love.pertemuan_3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alya_love.R
import com.example.alya_love.databinding.ActivityThirdResultBinding

class ThirdResultActivity : AppCompatActivity() {
 private lateinit var binding: ActivityThirdResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        val txtJudul = findViewById<TextView>(R.id.textView4)

        binding.textHalamanUtama.text = "$judul"
        binding.textDeskripsi.text = "$deskripsi"

        txtJudul.text = "$judul\n$deskripsi"
    }
}