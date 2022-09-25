package com.example.fernandoramos_tp2_listadeusuarios

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity_detail: AppCompatActivity() {

    private val usersRepo = UsersDB()
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        /* Recibo la información de la activity "padre" que invoco a esta activity */
        /* La información se traspasa con intent en este caso */
        val userID = intent.getIntExtra("userID", -1)
        val foundUser = usersRepo.findUserByID(userID)

        /* Chequeo que se encuentra el usuario por su ID */
        if(foundUser==null)
            throw IllegalArgumentException("No hay Usuario con el id $userID")
        else
            user = foundUser


        /* Instanciar elementos de la vista */
        val fullName = findViewById<TextView>(R.id.full_name)
        val age = findViewById<TextView>(R.id.age)
        val country = findViewById<TextView>(R.id.country)
        val email = findViewById<TextView>(R.id.email)
        val phoneNumber = findViewById<TextView>(R.id.phone)
        val streetAddress= findViewById<TextView>(R.id.address)

        /* Asignar los valores correspondientes del repo a la vista */
        fullName.text = user.fullName
        age.text = user.age.toString()
        country.text = user.country
        email.text = user.email
        phoneNumber.text = user.phone.toString()
        streetAddress.text = user.address
    }
}
