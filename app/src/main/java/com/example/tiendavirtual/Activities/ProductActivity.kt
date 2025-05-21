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
    private lateinit var AddProduct: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productos = arrayOf("producto 1","producto 2", "producto 3")
        var itemAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productos)
        binding.listap.adapter = itemAdapter
        binding.cart.setOnClickListener(
            {
                startActivity(Intent(this, ShoppingcartActivity::class.java))
                finish()
            }
        )

    }
}