package com.cibertec.bembos.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R
import com.cibertec.bembos.remote.ApiUtil
import com.example.myapp.api.ClientService
import com.example.myapp.models.Client
import com.cibertec.bembos.models.Department
import com.cibertec.bembos.models.District
import com.cibertec.bembos.models.Province
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private var clientService: ClientService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnLogin = findViewById<TextView>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Llamar a las funciones para poblar los spinners
        loadDepartamentos()
        loadProvincias()
        loadDistritos()

        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)
        btnRegistrarse.setOnClickListener {
            registerUser()
        }
    }

    private fun loadDepartamentos() {
        clientService = ApiUtil.clientService
        val call = clientService?.getDepartamentos()

        call?.enqueue(object : Callback<List<Department>> {
            override fun onResponse(call: Call<List<Department>>, response: Response<List<Department>>) {
                if (response.isSuccessful) {
                    val departamentos = response.body() ?: emptyList()
                    val spinner = findViewById<Spinner>(R.id.cboDepartamento)
                    val adapter = ArrayAdapter(this@RegisterActivity, android.R.layout.simple_spinner_item, departamentos)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = adapter
                } else {
                    Toast.makeText(this@RegisterActivity, "Error al cargar departamentos", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Department>>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error al cargar departamentos", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadProvincias() {
        clientService = ApiUtil.clientService
        val call = clientService?.getProvincias()

        call?.enqueue(object : Callback<List<Province>> {
            override fun onResponse(call: Call<List<Province>>, response: Response<List<Province>>) {
                if (response.isSuccessful) {
                    val provincias = response.body() ?: emptyList()
                    val spinner = findViewById<Spinner>(R.id.cboProvincia)
                    val adapter = ArrayAdapter(this@RegisterActivity, android.R.layout.simple_spinner_item, provincias)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = adapter
                } else {
                    Toast.makeText(this@RegisterActivity, "Error al cargar provincias", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Province>>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error al cargar provincias", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadDistritos() {
        clientService = ApiUtil.clientService
        val call = clientService?.getDistritos()

        call?.enqueue(object : Callback<List<District>> {
            override fun onResponse(call: Call<List<District>>, response: Response<List<District>>) {
                if (response.isSuccessful) {
                    val distritos = response.body() ?: emptyList()
                    val spinner = findViewById<Spinner>(R.id.cboDistrito)
                    val adapter = ArrayAdapter(this@RegisterActivity, android.R.layout.simple_spinner_item, distritos)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = adapter
                } else {
                    Toast.makeText(this@RegisterActivity, "Error al cargar distritos", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<District>>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error al cargar distritos", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun registerUser() {
        val inputCorreo = findViewById<EditText>(R.id.inputCorreo)
        val inputPass = findViewById<EditText>(R.id.inputPass)
        val inputNombre = findViewById<EditText>(R.id.inputNombre)
        val inputApellidoPaterno = findViewById<EditText>(R.id.inputApellidoPaterno)
        val inputApellidoMaterno = findViewById<EditText>(R.id.inputApellidoMaterno)
        val inputDocumento = findViewById<EditText>(R.id.inputDocumento)
        val inputDireccion = findViewById<EditText>(R.id.inputDireccion)
        val inputTelefono = findViewById<EditText>(R.id.inputTelefono)
        val inputTipoDocumento = findViewById<EditText>(R.id.inputTipoDocumento)

        val cboDepartamento = findViewById<Spinner>(R.id.cboDepartamento)
        val cboProvincia = findViewById<Spinner>(R.id.cboProvincia)
        val cboDistrito = findViewById<Spinner>(R.id.cboDistrito)

        val client = Client(
            id = null,
            nombre = inputNombre.text.toString(),
            ape_paterno = inputApellidoPaterno.text.toString(),
            ape_materno = inputApellidoMaterno.text.toString(),
            tipodocumento = inputTipoDocumento.text.toString(),
            numdocumento = inputDocumento.text.toString(),
            direccion = inputDireccion.text.toString(),
            departamento_id = cboDepartamento.selectedItem as Department,
            provincia_id = cboProvincia.selectedItem as Province,
            distrito_id = cboDistrito.selectedItem as District,
            telefono = inputTelefono.text.toString(),
            email = inputCorreo.text.toString(),
            clave = inputPass.text.toString()
        )

        clientService = ApiUtil.clientService
        val call = clientService?.createClient(client)

        call?.enqueue(object : Callback<Client> {
            override fun onResponse(call: Call<Client>, response: Response<Client>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Usuario registrado exitosamente", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@RegisterActivity, "Error al registrar usuario", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Client>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error de conexión", Toast.LENGTH_LONG).show()
            }
        })
    }
}
