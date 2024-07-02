package com.cibertec.bembos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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
        TODO("Not yet implemented")
    }
}