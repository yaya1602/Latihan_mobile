package com.example.alya_love.pertemuan_3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alya_love.R
import com.example.alya_love.databinding.ActivityCustomBinding

class CustomActivity : AppCompatActivity() {
 private lateinit var binding: ActivityCustomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        val txtDesc = findViewById<TextView>(R.id.txtDesc)

        binding.textHalamanUtama.text = "$judul"
        binding.textDeskripsi.text = "$deskripsi"

    }
}