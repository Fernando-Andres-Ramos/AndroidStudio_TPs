package com.example.fernandoramos_tp2_listadeusuarios

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


//El adapter recibe los datos que queremos mostrar luego en una vista. Y recibe el ViewHolder el cual sera el "molde" para estos datos.
class MyAdapter (val items: Array<User>):RecyclerView.Adapter<UserVH>(){

    //Creamos la vista sin personalizar, "inflamos" vistas vacias.
    //Crear una View a partir de un layout XML se denomina "inflar" el layout.
    //ViewGroup es una vista especial que contiene otras vistas. Hereda un context.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        //Creo un inflador
        val inflater = LayoutInflater.from(parent.context)
        //Creo/inflo la vista vacia, pasandole la vista a utilizar (la de xml)
        val emptyView = inflater.inflate(R.layout.user_item,parent,false)
        //Le paso la vista al ViewHolder, que justamente contiene vistas.
        return UserVH(emptyView)
    }

    //Enlaza cada dato de la posición correspondiente con su lugar en el ViewHolder
    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.full_nameTV.text = items[position].fullName
        holder.ageTV.text = items[position].age.toString()
        holder.countryTV.text = items[position].country
    }

    //Retorna cuantos Items deben verse
    override fun getItemCount(): Int {
        return items.size
    }

}