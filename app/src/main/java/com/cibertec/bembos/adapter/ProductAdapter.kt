package com.cibertec.bembos.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.bembos.Activity.DetalleProductoActivity
import com.cibertec.bembos.R
import com.cibertec.bembos.models.Product

// ProductAdapter.kt

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_products, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.txtProducto)
        private val productImage: ImageView = itemView.findViewById(R.id.imgProducto)
        private val productPrice: TextView = itemView.findViewById(R.id.txtPrecio)
        private val addToCartButton: TextView = itemView.findViewById(R.id.btnCartCard)

        init {
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetalleProductoActivity::class.java).apply {
                    // Pasar datos del producto seleccionado a DetalleProductoActivity
                    putExtra("PRODUCT_ID", products[adapterPosition].id)
                    putExtra("PRODUCT_NAME", products[adapterPosition].nombre)
                    putExtra("PRODUCT_DESCRIPTION", products[adapterPosition].descripcion)
                    putExtra("PRODUCT_PRICE", products[adapterPosition].precio)
                    // Aquí podrías agregar más datos del producto según necesites
                }
                context.startActivity(intent)
            }
        }

        fun bind(product: Product) {
            productName.text = product.nombre
            productPrice.text = "$ ${product.precio}"
            // Cargar imagen del producto usando Glide u otra biblioteca
            Glide.with(itemView.context)
                .load(product.foto_url)
                .into(productImage)
        }
    }
}
