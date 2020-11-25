package com.example.whatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Calls_1
import com.example.whatsapp.viewholder.CallsViewHolder

class CallsAdapter(private val modelList:List<Calls_1>): RecyclerView.Adapter<CallsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_call_layout, parent, false)
        return CallsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CallsViewHolder, position: Int) {
        val  model = modelList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
      return modelList.size
    }
}