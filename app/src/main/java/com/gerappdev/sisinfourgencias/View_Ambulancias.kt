package com.gerappdev.sisinfourgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gerappdev.sisinfourgencias.databinding.ActivityViewAmbulanciasBinding

class View_Ambulancias : AppCompatActivity() {
    private  lateinit var binding: ActivityViewAmbulanciasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAmbulanciasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnNuevaAmbulancia.setOnClickListener{
            val intent = Intent(this,BtnNuevaAmbulancia::class.java)
            startActivity(intent)
        }
        binding.bnVerAmbulanciasAmbulancia.setOnClickListener(){
            val intent = Intent(this, VerAmbulancias::class.java)
            startActivity(intent)
        }
    }
}