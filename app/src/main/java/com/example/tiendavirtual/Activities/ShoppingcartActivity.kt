package com.example.tiendavirtual.Activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R
import com.example.tiendavirtual.databinding.ActivityProductlistBinding

class ShoppingcartActivity : AppCompatActivity() {
    private var productos = emptyArray<String>()
    lateinit var adapter: ArrayAdapter<String>
    private lateinit var binding: ActivityProductlistBinding
    var btn_shop = findViewById<Button>(R.id.shop)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductlistBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val productos = arrayOf(
            "Producto 1",
            "Producto 2",
            "Producto 3",
            "Producto 4",
            "Producto 5"
        )

        var ItemAdapter = ArrayAdapter<String>(ShoppingcartActivity@this, android.R.layout.simple_list_item_1, productos)
        binding.ListaProductos.adapter = ItemAdapter
    }
}