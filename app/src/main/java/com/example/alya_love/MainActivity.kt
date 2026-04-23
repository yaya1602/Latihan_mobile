package com.example.alya_love

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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

        // 🔹 Tombol Rumus
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, bangun_ruang::class.java)
            intent.putExtra("judul", binding.judulAplikasi.text.toString())
            intent.putExtra("deskripsi", binding.deskripsi.text.toString())
            startActivity(intent)
        }

        // 🔹 Tombol Custom 1
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, ThirdResultActivity::class.java)
            intent.putExtra("judul", binding.judulAplikasi.text.toString())
            intent.putExtra("deskripsi", binding.deskripsi.text.toString())
            startActivity(intent)
        }

        // 🔹 Tombol Custom 2
//        binding.btnStart.setOnClickListener {
//            val intent = Intent(this, CustomActivity::class.java)
//            intent.putExtra("judul", binding.judulAplikasi.text.toString())
//            intent.putExtra("deskripsi", binding.deskripsi.text.toString())
//            startActivity(intent)
//        }

        // 🔹 Tombol Start → Buka Website
        binding.btnStart.setOnClickListener {
            val url = "https://alya-project.alwaysdata.net/dashboard-guest" // 🔥 GANTI dengan link kamu

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        // 🔹 Tombol Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    val sharedPref = getSharedPreferences("LOGIN", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    startActivity(Intent(this, ThirdActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(binding.btnLogout, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}