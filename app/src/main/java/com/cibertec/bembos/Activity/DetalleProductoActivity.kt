package com.cibertec.bembos.Activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R

class DetalleProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        val productId = intent.getIntExtra("PRODUCT_ID", -1)
        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION")
        val productPrice = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)

        // Aquí puedes vincular las vistas y mostrar los detalles del producto
        val productNameTextView: TextView = findViewById(R.id.textView8)
        val productDescriptionTextView: TextView = findViewById(R.id.txtDescripcion)
        val productPriceTextView: TextView = findViewById(R.id.txtPrecio)

        productNameTextView.text = productName
        productDescriptionTextView.text = productDescription
        productPriceTextView.text = "$ $productPrice"

        // Configurar el botón de añadir al carrito si es necesario
        val addToCartButton: TextView = findViewById(R.id.btnAñadirCarrito)
        addToCartButton.setOnClickListener {
            // Lógica para añadir el producto al carrito
            // Puedes implementar esta lógica según tus necesidades
        }

        // Configurar el botón de regreso
        val backButton: ImageView = findViewById(R.id.btnRegresar)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}