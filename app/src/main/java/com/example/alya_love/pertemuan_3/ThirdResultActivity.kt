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

        // ✅ TOOLBAR
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Halaman Buah"

        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        val txtJudul = findViewById<TextView>(R.id.textView4)

        binding.textHalamanUtama.text = "$judul"
        binding.textDeskripsi.text = "$deskripsi"

        txtJudul.text = "$judul\n$deskripsi"
    }

    // ✅ cara 1 (sudah kamu punya)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    // ✅ cara 2 (WAJIB TAMBAH biar pasti jalan)
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}