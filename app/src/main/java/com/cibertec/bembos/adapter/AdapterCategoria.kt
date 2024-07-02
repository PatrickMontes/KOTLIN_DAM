package com.cibertec.bembos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cibertec.bembos.R
import com.cibertec.bembos.models.Category

class AdapterCategoria  (context: Context?, private val listacategoria:List<Category>?): BaseAdapter() {
    private val layoutInflater: LayoutInflater

    init {
        layoutInflater=LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return listacategoria!!.size
    }

    override fun getItem(p0: Int): Any {
        return listacategoria!![p0]
    }


    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista = p1;
        if(vista == null ){
            //relacionamos la vista con el layout correspondiente
            vista=layoutInflater.inflate(R.layout.viewholder_category,p2,false)
            val objcategoria=getItem(p0) as Category
            //creamos los controles
            val txtCategory= vista!!.findViewById<TextView>(R.id.txtCategory)
            //agregamos los valores a la lista
            txtCategory.text=""+objcategoria.nombre
        }
        return vista!!;
    }
}