package com.example.fernandoramos_tp2_listadeusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //Antes de crear la vista, declaro la variable lista que sera un RecyclerView o null
    private var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_list)

        //Busco el id de la vista, que sera un RecyclerView
        val listAux: RecyclerView = findViewById(R.id.list)

        //Configuro el manejador/contenedor (this es la activity ejecutandose, vertical es la dirección, y reverseLayout el sentido
        listAux.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Asigno esta la listAux a mi list final que debo mostrar.
        this.list = listAux

        createList()
    }

    private fun createList(){
        val Users = getUsers()
        list!!.adapter == MyAdapter(Users)
    }
}