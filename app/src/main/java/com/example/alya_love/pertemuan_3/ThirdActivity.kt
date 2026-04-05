package com.example.alya_love.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alya_love.R
import com.example.alya_love.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_third)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//
//        val nama = findViewById<EditText>(R.id.editTextText)
//        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
//        val password = findViewById<EditText>(R.id.editTextTextPassword)
//        val button = findViewById<Button>(R.id.button3)


        binding.button3.setOnClickListener {

            val inputNama = binding.editTextText.text.toString()
            val inputEmail = binding.editTextTextEmailAddress.text.toString()
            val inputPassword = binding.editTextTextPassword.text.toString()

            if (inputNama.isEmpty() || inputEmail.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data berhasil dibuat", Toast.LENGTH_SHORT).show()

                // 🔥 PINDAH ACTIVITY DI SINI (cukup sekali)
                val intent = Intent(this, ThirdResultActivity::class.java)
                startActivity(intent)
            }
        }
    }
}