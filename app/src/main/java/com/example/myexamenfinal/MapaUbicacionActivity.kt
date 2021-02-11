package com.example.myexamenfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Transformations.map
import com.example.myexamenfinal.FormLatLongActivity.Companion.obj
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaUbicacionActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_ubicacion)

        if (getString(R.string.maps_api_key).isEmpty()) {
            Toast.makeText(
                this,
                "Add your own API key in MapWithMarker/app/secure.properties as MAPS_API_KEY=YOUR_API_KEY",
                Toast.LENGTH_LONG
            ).show()
        }

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

    }

    override fun onMapReady(p0: GoogleMap?) {
        val zoomLevel = 16.0f //This goes up to 21

        p0?.apply {
            val sydney = LatLng(obj?.long ?: 0.0, obj?.lat ?: 0.0)
            addMarker(
                MarkerOptions()
                    .position(sydney)
                    .title("Vive aqui " + obj?.nameMarc)

            )
            uiSettings?.isZoomControlsEnabled = true
            moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomLevel))
        }
    }
}