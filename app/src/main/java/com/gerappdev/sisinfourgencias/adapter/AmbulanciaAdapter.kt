package com.gerappdev.sisinfourgencias.adapter

import Mundo.Ambulancia
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gerappdev.sisinfourgencias.R
import ean.collections.TArrayList

class AmbulanciaAdapter(private val ambulancias:TArrayList<Ambulancia>): RecyclerView.Adapter<AmbulanciaViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbulanciaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AmbulanciaViewHolder(layoutInflater.inflate(R.layout.item_ambulancias, parent, false))
    }

    override fun onBindViewHolder(holder: AmbulanciaViewHolder, position: Int) {
        val item = ambulancias[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = ambulancias.size

}