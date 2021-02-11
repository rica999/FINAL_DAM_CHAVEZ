package com.example.myexamenfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormLatLongActivity : AppCompatActivity() {

    private var edtLat   : EditText? = null
    private var edtLong  : EditText? = null
    private var edtMarc  : EditText? = null
    private var btnEnviar: Button?   = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_lat_long)


        edtLat    = findViewById(R.id.edt_lat)
        edtLong   = findViewById(R.id.edt_long)
        edtMarc   = findViewById(R.id.edt_marc)
        btnEnviar = findViewById(R.id.btn_enviar)

        btnEnviar?.setOnClickListener {
            val long = edtLong?.text.toString()
            val lat  = edtLat?.text.toString()
            val name = edtMarc?.text.toString()

            if (MainActivity.isNullOrEmpty(long)) {
                Toast.makeText(this, "Ingrese una Longitud", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (MainActivity.isNullOrEmpty(lat)) {
                Toast.makeText(this, "Ingrese una Latitud", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (MainActivity.isNullOrEmpty(name)) {
                Toast.makeText(this, "Ingrese un nombre para el marcador", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            obj?.lat = lat.toDouble()
            obj?.long = long.toDouble()
            obj?.nameMarc = name

            val intent = Intent(this, FormLatLongActivity::class.java)
            startActivity(intent)
        }

    }

    companion object{
        var obj: ObjMarc? = ObjMarc()
    }

}

data class ObjMarc(
    var lat : Double? = null,
    var long : Double? = null,
    var nameMarc : String? = null,

)