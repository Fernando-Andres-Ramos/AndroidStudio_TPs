package com.example.fernandoramos_tp2_listadeusuarios

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ActivityDetail: AppCompatActivity(), View.OnClickListener {

    private lateinit var fullName: TextView
    private lateinit var age: TextView
    private lateinit var country: TextView
    private lateinit var email: TextView
    private lateinit var phoneNumber: TextView
    private lateinit var postcode: TextView
    private lateinit var img: ImageView


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
        fullName = findViewById(R.id.full_name)
        age = findViewById(R.id.age)
        country = findViewById(R.id.country)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phone)
        postcode= findViewById(R.id.postcode)
        img = findViewById(R.id.picture)

        /* Asignar los valores correspondientes del repo a la vista */
        fullName.text = nombre
        age.text = edad
        country.text = pais
        email.text = mail
        phoneNumber.text = telefono
        postcode.text = postal
        Glide.with(this).load(imagen).into(img)


        /* Asignar onclicks */
        phoneNumber.setOnClickListener(this)
        email.setOnClickListener(this)
        postcode.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.phone -> callNumber("${phoneNumber.text}")
            R.id.email -> sendEmail("${email.text}")
        }
    }

    /* Función para marcar el numero para llamada */
    private fun callNumber(number: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

    private fun sendEmail(emailAddress: String){
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$emailAddress");
        startActivity(intent)
    }
}
