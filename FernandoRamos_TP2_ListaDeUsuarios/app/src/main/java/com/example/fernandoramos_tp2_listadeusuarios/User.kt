package com.example.fernandoramos_tp2_listadeusuarios

//Creo la clase usuario como molde.
data class User(
    val fullName: String,
    val age : Int,
    val country: String
)

//Función para devolver un array de Usuarios
fun getUsers():Array<User>{
    return arrayOf(
        User("Fernando", 27, "Argentina"),
        User("Vera", 35, "Nicaragua"),
        User("Mauro",28,"Argentina"),
        User("Ayelen",29,"Argentina"),
        User("Patricia",52, "Argentina")
    )
}
