package com.example.fernandoramos_tp2_listadeusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //Antes de crear la vista, declaro la variable lista que sera un RecyclerView y un adapter.
    private lateinit var list: RecyclerView
    private lateinit var adapter: UsersListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_list)

        //Busco el id de la vista, que sera un RecyclerView
        list = findViewById(R.id.list)
        // Le doy al adapter el contexto en donde sera utilizado.
        adapter = UsersListAdapter(this)
        // Setear a la propiedad adaptadora de listAux el nuevo adapter
        list.adapter = adapter
        createList()
    }

    private fun createList(){
        val users = UsersDB().getUsers()
        adapter.setDataForAdapter(users)
    }
}