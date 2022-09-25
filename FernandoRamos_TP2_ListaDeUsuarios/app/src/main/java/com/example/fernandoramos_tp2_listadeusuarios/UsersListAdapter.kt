package com.example.fernandoramos_tp2_listadeusuarios

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView




//El adapter recibe el contexto,luego una vista. Y recibe el ViewHolder el cual sera el "molde" para estos datos.
class UsersListAdapter (
    private val context: Context)
    :RecyclerView.Adapter<UserVH>(){

    private var users: Array<User> = UsersDB().getUsers()

    // Establece la lista de películas que queremos mostrar, y avisa a RecyclerView que hubo cambios
    fun setDataForAdapter (newUsers: Array<User>){
        this.users = newUsers
        notifyDataSetChanged()
    }


    //Creamos la vista sin personalizar, "inflamos" vistas vacias.
    //Crear una View a partir de un layout XML se denomina "inflar" el layout.
    //ViewGroup es una vista especial que contiene otras vistas. Hereda un context.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        //Creo un inflador
        val inflater = LayoutInflater.from(context)
        //Creo/inflo la vista vacia, pasandole la vista a utilizar (la de xml)
        val emptyView = inflater.inflate(R.layout.user_item,parent,false)
        //Le paso la vista al ViewHolder, que justamente contiene vistas.
        return UserVH(emptyView)
    }

    //Enlaza cada dato de la posición correspondiente con su lugar en el ViewHolder
    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.full_nameTV.text = users[position].fullName
        holder.ageTV.text = users[position].age.toString()
        holder.countryTV.text = users[position].country
    }

    //Retorna cuantos Items deben verse
    override fun getItemCount(): Int {
        return users.size
    }

}