package com.example.tiendavirtual.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R

class SplashActivity : AppCompatActivity() {
    /* private val SPLASH_TIME_OUT: Long= 3000
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_splash)

         Handler(Looper.getMainLooper()).postDelayed({
             val intent = Intent(this, HomeActivity::class.java)
             startActivity(intent)
             finish()
             }, SPLASH_TIME_OUT)}*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var btn_1 = findViewById<Button>(R.id.btn_1)
        btn_1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    }
