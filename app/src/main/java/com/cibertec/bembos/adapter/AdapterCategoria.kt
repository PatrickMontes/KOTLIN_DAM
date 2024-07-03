package com.cibertec.bembos.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.bembos.R
import com.cibertec.bembos.models.Category
class AdapterCategoria(private val context: Context, private val listacategoria: List<Category>) :
    RecyclerView.Adapter<AdapterCategoria.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCategory: TextView = itemView.findViewById(R.id.txtCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoria = listacategoria[position]
        holder.txtCategory.text = categoria.nombre
    }

    override fun getItemCount(): Int {
        return listacategoria.size
    }
}