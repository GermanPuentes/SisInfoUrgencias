package com.gerappdev.sisinfourgencias

import Mundo.sistema_de_emergencia.agregarAmbulancia
import Mundo.sistema_de_emergencia.ambulancias
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gerappdev.sisinfourgencias.databinding.ActivityBtnNuevaAmbulanciaBinding

class BtnNuevaAmbulancia : AppCompatActivity() {
    private lateinit var binding: ActivityBtnNuevaAmbulanciaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBtnNuevaAmbulanciaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnAgregarNuevaAmbulancia.setOnClickListener {
            try {
            val codigo = binding.edtxtCodigoBtnNuevaAmbulancia.text.toString().toInt()
            val calle = binding.edtxtCalleBtnNuevaAmbulancia.text.toString().toInt()
            val carrera = binding.edtxtCarreraBtnNuevaAmbulancia.text.toString().toInt()

                if (codigo>0 && calle>=0  && carrera>=0 && ambulancias.find { it.getCodigo() == codigo }==null ){
                    agregarAmbulancia(codigo,calle,carrera)
                    Toast.makeText(this,"Ambulancia agregada",Toast.LENGTH_LONG).show()
                    ambulancias.find { it.getCodigo() == codigo }
                    for (i in ambulancias){
                        println(i.toString())
                    }
                }
                else{
                    Toast.makeText(this,"Datos invalidos",Toast.LENGTH_LONG).show()
                    }
               }
            catch (e: Exception){
                Toast.makeText(this,"Datos invalidos",Toast.LENGTH_LONG).show()
             }
        }
    }
}