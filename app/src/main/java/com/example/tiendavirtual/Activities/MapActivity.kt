package com.example.tiendavirtual.Activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val ubicacion1 = LatLng(4.609722, -74.081667)//Bogotá
    private val ubicacion2 = LatLng(6.230833, -75.590553)//Medellin
    private val ubicacion3 = LatLng(3.4516,-76.5320)//Cali

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setupButtonListeners()

    }

    private fun setupButtonListeners() {
        findViewById<Button>(R.id.btn_ubicacion1).setOnClickListener {
            moveToLocation(ubicacion1, "Bogotá")
        }
        findViewById<Button>(R.id.btn_ubicacion2).setOnClickListener {
            moveToLocation(ubicacion2, "Medellin")
        }
        findViewById<Button>(R.id.btn_ubicacion3).setOnClickListener {
            moveToLocation(ubicacion2, "Cali")
        }

    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Habilitar controles de zoom
        mMap.uiSettings.isZoomControlsEnabled = true

        // Mover a la primera ubicación por defecto
        moveToLocation(ubicacion1, "Bogotá")
    }

    private fun moveToLocation(location: LatLng, title: String) {
        // Limpiar marcadores anteriores
        mMap.clear()

        // Añadir un nuevo marcador en la ubicación seleccionada
        mMap.addMarker(MarkerOptions().position(location).title(title))

        // Mover la cámara a la ubicación y hacer zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f))
    }


}