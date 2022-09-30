package com.example.fernandoramos_tp2_listadeusuarios

//Creo la clase usuario como molde.
data class User(
    val id: String,
    val fullName: String,
    val age : String,
    val country: String,
    val img: String,
    val email: String,
    val phone: String,
    val address: String
)
