package com.example.alya_love.pertemuan_3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alya_love.R

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        val txtDesc = findViewById<TextView>(R.id.txtDesc)

        txtTitle.text = judul
        txtDesc.text = deskripsi
    }
}