package com.example.fernandoramos_tp2_listadeusuarios

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ServiceRandomUser {
    @GET("api")
    fun search(
        @Query("results")
        cant: String,
        @Query("nat")
        region: String
    ): Call<ResponseFromApi>
}

//Lista de resultados tipo PeliculaOmdb
data class ResponseFromApi(
    val results: List<UserFromApi>
)

//Molde de datos que se obtendran desde la API
data class UserFromApi(
    val login: IdStructure,
    val name: NameStructure,
    val dob: AgeStructure,
    val picture: PictureStructure,
    val location: LocationStructure,
    val email:String,
    val phone: String,
)

/* Estructuras internas para adaptar el molde general UserFromApi */

data class IdStructure(
    val uuid: String
)

data class NameStructure(
    val first: String,
    val last: String
)

data class AgeStructure(
    val age: String
)

data class PictureStructure(
    val large: String
)

data class LocationStructure(
    val street: StreetStructure,
    val country: String
)

data class StreetStructure(
    val number: Int,
    val name: String
)
