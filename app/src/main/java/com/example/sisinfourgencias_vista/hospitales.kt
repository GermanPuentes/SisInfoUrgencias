package com.example.sisinfourgencias_vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class hospitales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospitales)

        //Asociación de variables con objeto de la parte gráfica
        val agregarHospital = findViewById<AppCompatButton>(R.id.agregar_hospital)

        // Método para pasar de una actividad a la otra
        agregarHospital.setOnClickListener {
            val intent = Intent(this, hospital_nuevo::class.java)
            startActivity(intent)
        }
    }
}