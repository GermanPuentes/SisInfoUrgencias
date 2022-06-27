package com.example.sisinfourgencias_vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asociación de variables con objeto de la parte gráfica
        val botonAmbulancia = findViewById<AppCompatButton>(R.id.bn_ambulancias)
        val botonHospital = findViewById<AppCompatButton>(R.id.bn_hospitales)
        val botonPacientes = findViewById<AppCompatButton>(R.id.bn_pacientes)

        // Método para pasar de una actividad a la otra
        botonAmbulancia.setOnClickListener {
            val intent = Intent(this, ambulancias::class.java)
            startActivity(intent)
        }

        botonHospital.setOnClickListener {
            val intent = Intent(this, hospitales::class.java)
            startActivity(intent)
        }

        botonPacientes.setOnClickListener {
            val intent = Intent(this, pacientes::class.java)
            startActivity(intent)
        }

    }
}