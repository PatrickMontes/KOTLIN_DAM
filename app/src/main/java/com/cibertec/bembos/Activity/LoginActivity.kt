package com.cibertec.bembos.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R
import com.cibertec.bembos.remote.ApiUtil
import com.example.myapp.api.ClientService
import com.example.myapp.models.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnRegistrarte = findViewById<TextView>(R.id.btnRegistrarte)
        val btnIniciarSesion = findViewById<Button>(R.id.btnRegistrarse)
        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)

        btnRegistrarte.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnIniciarSesion.setOnClickListener {
            val email = inputEmail.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                iniciarSesion(email, password)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun iniciarSesion(email: String, password: String) {
        val clientService: ClientService? = ApiUtil.clientService
        val client = Client(
            id = null,
            nombre = null,
            ape_paterno = null,
            ape_materno = null,
            tipodocumento = null,
            numdocumento = null,
            direccion = null,
            departamento_id = null,
            provincia_id = null,
            distrito_id = null,
            telefono = null,
            email = email,
            clave = password
        )

        clientService?.signin(client)?.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val message = response.body()
                    if (message == "Bienvenido") {
                        Toast.makeText(this@LoginActivity, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                        // Aquí puedes redirigir al usuario a otra actividad si lo deseas
                    } else {
                        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Error en el servidor", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
