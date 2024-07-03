package com.cibertec.bembos.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R
import com.cibertec.bembos.models.SignInResponse
import com.cibertec.bembos.remote.ApiUtil
import com.example.myapp.models.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)
        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)

        btnRegistrarse.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val client = Client(email = email, clave = password)
                signin(client)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<TextView>(R.id.btnRegistrarte).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signin(client: Client) {
        val clientService = ApiUtil.clientService
        if (clientService != null) {
            val call = clientService.signin(client)
            call.enqueue(object : Callback<SignInResponse> {
                override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                    if (response.isSuccessful) {
                        val signInResponse = response.body()
                        if (signInResponse != null) {
                            Toast.makeText(this@LoginActivity, signInResponse.mensaje, Toast.LENGTH_LONG).show()
                            if (signInResponse.mensaje == "Bienvenido") {
                                // Redirigir a ActivityMenu
                                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                                startActivity(intent)
                                finish() // Opcional: cierra LoginActivity
                            }
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Error en usuario o contraseña", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Error de conexión: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        } else {
            Toast.makeText(this, "Error al obtener el servicio de cliente", Toast.LENGTH_SHORT).show()
        }
    }
}