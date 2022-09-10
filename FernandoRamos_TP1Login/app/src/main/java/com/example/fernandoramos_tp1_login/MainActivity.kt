package com.example.fernandoramos_tp1_login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible

/* Heredar la clase AppCompat.... en el Main*/
class MainActivity : AppCompatActivity() {

    /* Redefinir la función onCreate */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
        hideMessage()
    }

    /* Capturar el texto de los editText y evaluar su contenido */
    private fun login() {

        /* Capturar los elementos del XML */
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val message: TextView = findViewById(R.id.message)
        val loginButton: Button = findViewById(R.id.confirm_button)

        message.isInvisible = true


        fun validateEmail(email:String):Boolean {
            /* No vacio */
            if (email.isEmpty())
                return false

            /* Sin espacios */
            if(!email.all {char->char!=' '})
                return false

            /* Un solo @ */
            if(email.filter{ c->c=='@'}.length != 1)
                return false

            /* Sin 2 puntos seguidos */
            if(email.contains(".."))
                return false

            return true
        }


        fun validatePassword(password: String): Boolean {
            /* Mayor o igual a 8 */
            if(password.length<8)
                return false

            /* Que no sean todos mayuscula ni todos minuscula */
            if(password.all{c-> c == c.uppercaseChar()}||
                password.all{c-> c == c.lowercaseChar()})
                return false

            /* Al menos 1 numero */
            if(password.none { c -> c.isDigit() })
                return false

            /* Que solo sea alfanumerico */
            if(!password.all { c -> c in 'A'..'Z' || c in 'a'..'z' || c in '0'..'9'})
                return false

            return true
        }

        /* Función a ejecutar cuando se clickea el boton */
        val clickListener = View.OnClickListener {
            val emailState = validateEmail(emailInput.text.toString())
            val passState = validatePassword(passwordInput.text.toString())
            if (!emailState) {
                message.text = resources.getString(R.string.errorEmail)
                message.setTextColor(resources.getColor(R.color.red))
                message.isInvisible = false
            } else {
                if (!passState) {
                    message.text = (resources.getString(R.string.errorPassword))
                    message.setTextColor(resources.getColor(R.color.red))
                    message.isInvisible = false
                } else {
                    message.text = (resources.getString(R.string.successLogin))
                    message.isInvisible = false
                    message.setTextColor(resources.getColor(R.color.darkGreen))
                }
            }
        }

        /* Asignar el setOnClickListener al boton con su funcion a ejecutar */
        loginButton.setOnClickListener(clickListener)
    }

    private fun hideMessage(){
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val message: TextView = findViewById(R.id.message)

        val textWatcher = object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                message.isInvisible = true
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
        emailInput.addTextChangedListener(textWatcher)
        passwordInput.addTextChangedListener(textWatcher)
    }
}
