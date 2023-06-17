package com.chenao.healthylife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FormPagerAdapter(private val formList: List<Int>) : RecyclerView.Adapter<FormPagerAdapter.FormViewHolder>() {

    inner class FormViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return FormViewHolder(view)
    }

    override fun getItemCount(): Int {
        return formList.size
    }

    override fun getItemViewType(position: Int): Int {
        return formList[position]
    }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) {
        // No se requiere hacer nada aquí
    }
}
