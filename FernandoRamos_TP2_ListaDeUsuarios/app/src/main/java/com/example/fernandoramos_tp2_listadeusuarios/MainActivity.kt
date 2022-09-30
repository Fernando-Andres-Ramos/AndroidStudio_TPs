package com.example.fernandoramos_tp2_listadeusuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //Antes de crear la vista, declaro la variable lista que sera un RecyclerView y un adapter.
    private lateinit var list: RecyclerView
    private lateinit var adapter: UsersListAdapter
    private lateinit var UsersDB: UsersDB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_list)

        UsersDB = UsersDB(this)

        //Busco el id de la vista, que sera un RecyclerView
        list = findViewById(R.id.list)
        // Le doy al adapter el contexto en donde sera utilizado y un callback que setea un usuario clickeado
        adapter = UsersListAdapter(this) { user ->
            val intent = Intent(this, Activity_detail::class.java)
            intent.putExtra("idUser", user.id)
            startActivity(intent)
        }
        // Setear a la propiedad adaptadora desde adapter
        list.adapter = adapter
        createList()
    }

    private fun createList(){
        UsersDB.getUsers(
            err = { t -> Log.e("CURSO", "No se pudo obtener los usuarios", t)},
            res = {users -> adapter.setDataForAdapter(users)}
        )
    }
}