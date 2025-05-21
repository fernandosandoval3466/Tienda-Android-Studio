package com.example.tiendavirtual.Fragments


import com.example.tiendavirtual.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DetalleProductoFragment : Fragment() {
    private lateinit var producto: Producto
    companion object {
        private const val ARG_PRODUCTO = "producto"

        fun newInstance(producto: Producto): DetalleProductoFragment {
            val fragment = DetalleProductoFragment()
            val args = Bundle()
            // Usamos putParcelable para serializacion
            args.putParcelable(ARG_PRODUCTO, producto)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_producto, container, false)

        val imagenProducto: ImageView = view.findViewById(R.id.detalle_Imagen_producto)
        val nombreProducto: TextView = view.findViewById(R.id.detalle_Nombre_producto)
        val descripcionProducto: TextView = view.findViewById(R.id.precio_producto)
        val precioProducto: TextView = view.findViewById(R.id.descripcion_producto)
        val botonComprar: Button = view.findViewById(R.id.btn_comprar)

        // Configurar la vista con los datos del producto
        imagenProducto.setImageResource(producto.imagenResourceId)
        nombreProducto.text = producto.nombre
        descripcionProducto.text = producto.descripcion
        precioProducto.text = "$${producto.precio}"

        botonComprar.setOnClickListener {
            // Lógica para añadir al carrito
            Toast.makeText(requireContext(), "Producto añadido al carrito", Toast.LENGTH_SHORT).show()
        }

        return view
    }


}


