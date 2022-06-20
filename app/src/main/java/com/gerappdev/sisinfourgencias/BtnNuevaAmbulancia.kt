package com.gerappdev.sisinfourgencias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gerappdev.sisinfourgencias.databinding.ActivityBtnNuevaAmbulanciaBinding

class BtnNuevaAmbulancia : AppCompatActivity() {
    private lateinit var binding: ActivityBtnNuevaAmbulanciaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBtnNuevaAmbulanciaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}