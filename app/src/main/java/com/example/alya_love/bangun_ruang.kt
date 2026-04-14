package com.example.alya_love

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alya_love.databinding.ActivityBangunRuangBinding

class bangun_ruang : AppCompatActivity() {
    private lateinit var binding: ActivityBangunRuangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val panjang = findViewById<EditText>(R.id.panjang)
        val lebar = findViewById<EditText>(R.id.lebar)
        val tinggi = findViewById<EditText>(R.id.tinggi)
        val btn = findViewById<Button>(R.id.btnHitung)
        val hasil = findViewById<TextView>(R.id.hasil)


        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        binding.textHalamanUtama.text = "$judul"
        binding.textDeskripsi.text = "$deskripsi"

        btn.setOnClickListener {
            val pStr = panjang.text.toString()
            val lStr = lebar.text.toString()
            val tStr = tinggi.text.toString()

            if (pStr.isEmpty() || lStr.isEmpty() || tStr.isEmpty()) {
                hasil.text = "Tidak boleh kosong!"
            } else {
                val p = pStr.toDouble()
                val l = lStr.toDouble()
                val t = tStr.toDouble()

                val volume = p * l * t
                hasil.text = "Hasil: $volume"
            }
        }
    }
}