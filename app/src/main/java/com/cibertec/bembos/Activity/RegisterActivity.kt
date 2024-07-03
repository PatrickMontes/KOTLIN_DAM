package com.cibertec.bembos.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R
import com.cibertec.bembos.remote.ApiUtil
import com.example.myapp.models.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {


    private lateinit var inputCorreo: EditText
    private lateinit var inputPass: EditText
    private lateinit var inputNombre: EditText
    private lateinit var inputApellidoMaterno: EditText
    private lateinit var inputApellidoPaterno: EditText
    private lateinit var inputTipoDocumento: EditText
    private lateinit var inputDocumento: EditText
    private lateinit var inputTelefono: EditText
    private lateinit var inputDireccion: EditText
    private lateinit var btnRegistrarse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        inputCorreo = findViewById(R.id.inputCorreo)
        inputPass = findViewById(R.id.inputPass)
        inputNombre = findViewById(R.id.inputNombre)
        inputApellidoMaterno = findViewById(R.id.inputApellidoMaterno)
        inputApellidoPaterno = findViewById(R.id.inputApellidoPaterno)
        inputTipoDocumento = findViewById(R.id.inputTipoDocumento)
        inputDocumento = findViewById(R.id.inputDocumento)
        inputTelefono = findViewById(R.id.inputTelefono)
        inputDireccion = findViewById(R.id.inputDireccion)
        btnRegistrarse = findViewById(R.id.btnRegistrarse)

        btnRegistrarse.setOnClickListener {
            registerUser()
        }
    }







    private fun registerUser() {
        val clientService = ApiUtil.clientService

        val email = inputCorreo.text.toString()
        val password = inputPass.text.toString()
        val nombre = inputNombre.text.toString()
        val apellidoMaterno = inputApellidoMaterno.text.toString()
        val apellidoPaterno = inputApellidoPaterno.text.toString()
        val tipoDocumento = inputTipoDocumento.text.toString()
        val documento = inputDocumento.text.toString()
        val telefono = inputTelefono.text.toString()
        val direccion = inputDireccion.text.toString()

        // Validate inputs
        if (email.isEmpty() || password.isEmpty() || nombre.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos obligatorios.", Toast.LENGTH_SHORT).show()
            return
        }

        val newClient = Client(
            email = email,
            clave = password,
            nombre = nombre,
            ape_materno = apellidoMaterno,
            ape_paterno = apellidoPaterno,
            tipodocumento = tipoDocumento,
            numdocumento = documento,
            telefono = telefono,
            direccion = direccion
        )

        clientService?.createClient(newClient)?.enqueue(object : Callback<Client> {
            override fun onResponse(call: Call<Client>, response: Response<Client>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    // Redirect to LoginActivity
                    val intent = Intent(this@RegisterActivity, MenuActivity::class.java)
                    startActivity(intent)
                    finish()  // Optional: Finish RegisterActivity to remove it from the back stack
                } else {
                    Toast.makeText(this@RegisterActivity, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Client>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}