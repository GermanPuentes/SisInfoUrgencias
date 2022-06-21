package com.gerappdev.sisinfourgencias

import Mundo.sistema_de_emergencia.ambulancias
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gerappdev.sisinfourgencias.adapter.AmbulanciaAdapter
import com.gerappdev.sisinfourgencias.databinding.ActivityVerAmbulanciasBinding

class VerAmbulancias : AppCompatActivity() {
    private lateinit var binding: ActivityVerAmbulanciasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerAmbulanciasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }
    fun initRecyclerView(){
        val recyclerView = binding.recyclerAmbulanciasVerAmbulancias
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AmbulanciaAdapter(ambulancias)
    }
}