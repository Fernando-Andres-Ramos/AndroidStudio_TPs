package com.example.fernandoramos_tp2_listadeusuarios

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Activity_detail: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        /* Recibo la información de la activity "padre" que invoco a esta activity */
        /* La información se traspasa con intent en este caso */

        val nombre = intent.getStringExtra("fullName")
        val edad = intent.getStringExtra("age")
        val pais = intent.getStringExtra("country")
        val mail = intent.getStringExtra("email")
        val telefono = intent.getStringExtra("phone")
        val postal = intent.getStringExtra("postalCode")
        val imagen = intent.getStringExtra("img")


        /* Instanciar elementos de la vista */
        val fullName = findViewById<TextView>(R.id.full_name)
        val age = findViewById<TextView>(R.id.age)
        val country = findViewById<TextView>(R.id.country)
        val email = findViewById<TextView>(R.id.email)
        val phoneNumber = findViewById<TextView>(R.id.phone)
        val postcode= findViewById<TextView>(R.id.postcode)
        val img = findViewById<ImageView>(R.id.picture)

        /* Asignar los valores correspondientes del repo a la vista */
        fullName.text = nombre
        age.text = edad
        country.text = pais
        email.text = mail
        phoneNumber.text = telefono
        postcode.text = postal
        Glide.with(this).load(imagen).into(img)
    }
}
