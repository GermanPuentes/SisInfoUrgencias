package com.example.sisinfourgencias_vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class ambulancias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambulancias)

        //Asociación de variables con objeto de la parte gráfica
        val agregarAmbulancia = findViewById<AppCompatButton>(R.id.agregar_ambulancia)


        // Método para pasar de una actividad a la otra
        agregarAmbulancia.setOnClickListener {
            val intent = Intent(this, ambulancia_nueva::class.java)
            startActivity(intent)
        }
    }
}