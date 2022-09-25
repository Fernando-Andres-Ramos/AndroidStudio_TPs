package com.example.fernandoramos_tp2_listadeusuarios

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Viewholder seria como un contenedor de vistas vacio, que luego se personalizara.
// Se le pasa una vista, y el viewholder hacer referencias a cada cosa que tiene la vista y debe modificar
// Esto se crea en Adapter.onCreateViewHolder.


class UserVH(userView: View) : RecyclerView.ViewHolder(userView) {
    val full_nameTV: TextView
    val ageTV: TextView
    val countryTV: TextView
    val imgTV: ImageView

    // Cuerpo del constructor
    init {
        full_nameTV = userView.findViewById(R.id.full_name)
        ageTV = userView.findViewById(R.id.age)
        countryTV = userView.findViewById(R.id.country)
        imgTV = userView.findViewById(R.id.picture)
    }
}