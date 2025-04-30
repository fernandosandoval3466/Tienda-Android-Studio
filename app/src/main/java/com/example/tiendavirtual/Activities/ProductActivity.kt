package com.example.tiendavirtual.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R
import com.example.tiendavirtual.databinding.ActivityProductlistBinding

class ProductActivity : AppCompatActivity() {
    private var productos = ArrayList<String>()
    lateinit var arrayAdapter: ArrayAdapter<*>
    private lateinit var binding: ActivityProductlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productos = arrayOf("producto 1",
                "producto 2", "producto 3", "producto 4", "producto 5", "producto 6", "producto 7", "producto 8", "producto 9", "producto 10")
        var itemAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productos)
        binding.listap.adapter = itemAdapter
        binding.Cart.setOnClickListener(
            {
                startActivity(Intent(this, ShoppingcartActivity::class.java))
                finish()
            }
        )


    }
}