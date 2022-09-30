package com.example.fernandoramos_tp2_listadeusuarios

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

//Interfaz que
interface ServiceRandomUser {
    @GET("/")
    fun search(
        @Query("apikey")
        apikey: String,
        @Query("type")
        type: String,
        @Query("s")
        s:String
    ): Call<ResponseFromApi>
}

//Lista de resultados tipo PeliculaOmdb
data class ResponseFromApi(
    val Search: List<UserFromApi>
)

//Molde de datos que se obtendran desde la API
data class UserFromApi(
    val Title: String,
    val Year: String,
    val Poster: String,
    val Type: String,
    val imdbID: String,
)