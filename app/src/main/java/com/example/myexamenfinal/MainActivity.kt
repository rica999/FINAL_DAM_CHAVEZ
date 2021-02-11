package com.example.myexamenfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var edtUser : EditText? = null
    private var edtPass : EditText? = null
    private var btnLogin: Button?   = null

    private val listUserPermitidos = mutableListOf<UsersPermitidos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUser  = findViewById(R.id.edt_user)
        edtPass  = findViewById(R.id.edt_pass)
        btnLogin = findViewById(R.id.btn_login)

        listUserPermitidos.add(UsersPermitidos("angel"   , "123456"))
        listUserPermitidos.add(UsersPermitidos("fabrizio", "123456"))
        listUserPermitidos.add(UsersPermitidos("alvaro"  , "123456"))
        listUserPermitidos.add(UsersPermitidos("ricardo" , "123456"))
        listUserPermitidos.add(UsersPermitidos("rhisto"  , "123456"))

        btnLogin?.setOnClickListener {
            val user = edtUser?.text.toString()
            val pass = edtPass?.text.toString()

            if (isNullOrEmpty(user)) {
                Toast.makeText(this, "Ingrese un usuario", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isNullOrEmpty(pass)) {
                Toast.makeText(this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(listUserPermitidos.firstOrNull{it.user == user} == null) {
                Toast.makeText(this, "El usuario $user no se encuentra registrado", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(listUserPermitidos.firstOrNull{it.pass == pass} == null) {
                Toast.makeText(this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, FormLatLongActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun isNullOrEmpty(text: Any): Boolean {
            return when (text) {
                is String -> text.trim().isEmpty()
                is EditText -> text.text.trim().isEmpty()
                else -> false
            }
        }
    }
}

data class UsersPermitidos(
    var user: String? = null,
    var pass: String? = null,
)