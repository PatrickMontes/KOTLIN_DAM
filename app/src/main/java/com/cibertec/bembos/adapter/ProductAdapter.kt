package com.cibertec.bembos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.bembos.R
import com.cibertec.bembos.models.Product

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtProducto: TextView = itemView.findViewById(R.id.txtProducto)
        val imgProducto: ImageView = itemView.findViewById(R.id.imgProducto)
        val txtPrecio: TextView = itemView.findViewById(R.id.txtPrecio)
        val btnCartCard: TextView = itemView.findViewById(R.id.btnCartCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_products, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.txtProducto.text = product.nombre
        holder.txtPrecio.text = product.precio.toString()
        Glide.with(holder.itemView.context).load(product.foto_url).into(holder.imgProducto)
        holder.btnCartCard.setOnClickListener {
            // Acción para añadir al carrito
        }
    }

    override fun getItemCount(): Int = products.size
}
