package com.example.fernandoramos_tp2_listadeusuarios

import android.content.Context
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/* Repositorio de datos mockeados. */
class UsersDB (context: Context){

    /* Obtener personas de estos paises */
    private val region: String = "us,es,br,fr,au"

    /* Cantidad de personas obtenidas */
    private val cantUsers: String = "25"

    private val serviceAPI: ServiceRandomUser


    init {
        val moshi: Moshi = Moshi.Builder() // Builder -> objeto constructor
            .add(KotlinJsonAdapterFactory())// Agregamos esto para que Moshi pueda convertir clases de Kotlin a Json automáticamente
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        serviceAPI = retrofit.create(ServiceRandomUser::class.java)
    }

    /* Función/Metodo para obtener usuarios. Se le pasa 2 callbacks */
    fun getUsers(
        res: (List<User>) -> Unit ,
        err: (Throwable) -> Unit
    ){

        /* Se hace la petición a la url por retrofit, pasandole parametros. */
        val requestToApi = serviceAPI.search(cant = cantUsers, region = region)

        /* Poner el request en espera */
        requestToApi.enqueue(object : Callback<ResponseFromApi>{

            /* Cuando se obtiene respuesta del request */
            override fun onResponse(
                call: Call<ResponseFromApi>,
                response: Response<ResponseFromApi>
            ) {
                if (response.isSuccessful) {
                    val result: ResponseFromApi? = response.body()

                    if (result == null) {
                        throw IllegalStateException("Llamada exitosa, pero no hay usuarios que mostrar")
                    } else {
                        val usersAPI = result.results
                        val users = ArrayList<User>()

                        for (userAPI in usersAPI) {
                            val user = User(
                                id = userAPI.login.uuid,
                                fullName = "${userAPI.name.first} ${userAPI.name.last}",
                                age = "Edad: ${userAPI.dob.age}",
                                img = userAPI.picture.large,
                                adress = "${userAPI.location.street.name} ${userAPI.location.street.number}",
                                email = userAPI.email,
                                phone = userAPI.phone,
                                country = userAPI.location.country
                            )
                            users.add(user)
                        }
                        res(users)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseFromApi>, t: Throwable) {
                err(t)
            }
        })
    }

}


