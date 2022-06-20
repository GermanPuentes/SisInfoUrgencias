package com.gerappdev.sisinfourgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gerappdev.sisinfourgencias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnAccidenteMain.setOnClickListener(){
            val intent = Intent(this, ViewAccidentes::class.java)
            startActivity(intent)
        }
        binding.bnAmbulanciasMain.setOnClickListener(){
            val intent = Intent(this, View_Ambulancias::class.java)
            startActivity(intent)
        }
        binding.bnHospilaesMain.setOnClickListener(){
            val intent = Intent(this, ViewHospitales::class.java)
            startActivity(intent)
        }
    }
}