package com.example.alya_love

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.alya_love.databinding.ActivityMainBinding
import com.example.alya_love.pertemuan_3.CustomActivity
import com.example.alya_love.pertemuan_3.ThirdActivity
import com.example.alya_love.pertemuan_3.ThirdResultActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnRumus = findViewById<Button>(R.id.btnRumus)
        val btnCustom1 = findViewById<Button>(R.id.btnCustom1)
        val btnCustom2 = findViewById<Button>(R.id.btnCustom2)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Tombol 1 → Bangun Ruang
        btnRumus.setOnClickListener {
            val intent = Intent(this, bangun_ruang::class.java)
            intent.putExtra("judul", binding.judulAplikasi.text.toString())
            intent.putExtra("deskripsi", binding.deskripsi.text.toString())
            startActivity(intent)
        }

        // Tombol 2 → Custom 1 (ThirdResultActivity)
        btnCustom1.setOnClickListener {
            val intent = Intent(this, ThirdResultActivity::class.java)
            intent.putExtra("judul", binding.judulAplikasi.text.toString())
            intent.putExtra("deskripsi", binding.deskripsi.text.toString())
            startActivity(intent)
        }

        // Tombol 3 → Custom 2 (CustomActivity)
        btnCustom2.setOnClickListener {
            val intent = Intent(this, CustomActivity::class.java)
            intent.putExtra("judul", binding.judulAplikasi.text.toString())
            intent.putExtra("deskripsi", binding.deskripsi.text.toString())
            startActivity(intent)
        }

        // Tombol 4 → Logout
        btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    startActivity(Intent(this, ThirdActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(btnLogout, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}