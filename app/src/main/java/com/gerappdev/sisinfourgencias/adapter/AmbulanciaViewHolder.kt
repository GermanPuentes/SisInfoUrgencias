package com.gerappdev.sisinfourgencias.adapter

import Mundo.Ambulancia
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gerappdev.sisinfourgencias.R

class AmbulanciaViewHolder(view:View): RecyclerView.ViewHolder(view) {
    val codigo = view.findViewById<TextView>(R.id.txt_codigo_itemAmbulancias)
    val calle = view.findViewById<TextView>(R.id.txt_Calle_itemAmbulancia)
    val carrera = view.findViewById<TextView>(R.id.txt_Carrera_itemAmulancia)

    fun render(ambulancia: Ambulancia) {
        codigo.text = ambulancia.getCodigo().toString()
        calle.text = ambulancia.getUbicacion().getCalle().toString()
        carrera.text = ambulancia.getUbicacion().getCarrera().toString()

    }

}
