package com.example.whatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Calls_1
import com.example.whatsapp.data.Status_1
import com.example.whatsapp.viewholder.CallsViewHolder
import com.example.whatsapp.viewholder.StatusViewHolder

class StatusAdapter(private val modelList:List<Status_1>):RecyclerView.Adapter<StatusViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_status, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val  model = modelList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }
}