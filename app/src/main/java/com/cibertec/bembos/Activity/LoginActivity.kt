package com.cibertec.bembos.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Buscar el TextView por su ID
        val btnRegistrarte = findViewById<TextView>(R.id.btnRegistrarte)

        // Configurar OnClickListener para el TextView
        btnRegistrarte.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
