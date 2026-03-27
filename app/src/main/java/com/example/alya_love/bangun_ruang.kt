package com.example.alya_love

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class bangun_ruang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bangun_ruang)
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

        btn.setOnClickListener {
            val p = panjang.text.toString().toDouble()
            val l = lebar.text.toString().toDouble()
            val t = tinggi.text.toString().toDouble()

            val volume = p * l * t
            hasil.text = "Hasil: $volume"
        }
    }
}