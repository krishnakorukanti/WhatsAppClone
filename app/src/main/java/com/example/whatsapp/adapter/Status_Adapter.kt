package com.example.whatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Status_1
import com.example.whatsapp.viewholder.Status_ViewHolder

class Status_Adapter(private val modelList:List<Status_1>): RecyclerView.Adapter<Status_ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Status_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_status_layout, parent, false)
        return Status_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Status_ViewHolder, position: Int) {
        val  model = modelList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }
}