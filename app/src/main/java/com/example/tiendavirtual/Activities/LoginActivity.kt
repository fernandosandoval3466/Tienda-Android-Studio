package com.example.tiendavirtual.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var btn_login = findViewById<Button>(R.id.btnlogin)
        btn_login.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
            finish()
        }
}
}