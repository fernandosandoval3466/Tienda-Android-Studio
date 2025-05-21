package com.example.tiendavirtual.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.MainActivity
import com.example.tiendavirtual.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_register)

        val btnRegistrar: Button = findViewById(R.id.btn_registrar)
        btnRegistrar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }
}