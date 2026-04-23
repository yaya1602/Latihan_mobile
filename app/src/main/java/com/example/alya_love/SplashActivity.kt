package com.example.alya_love

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.alya_love.pertemuan_3.ThirdActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPref = getSharedPreferences("LOGIN", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        Handler(Looper.getMainLooper()).postDelayed({

            if (isLogin) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, ThirdActivity::class.java))
            }

            finish()

        }, 2000) // 2 detik
    }
}