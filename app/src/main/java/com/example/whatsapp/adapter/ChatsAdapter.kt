package com.example.whatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.RecyclerViewItemClicked
import com.example.whatsapp.data.Users
import com.example.whatsapp.viewholder.ChatsViewHolder

class ChatsAdapter(
    private val usersList: List<Users>,
    private val recyclerViewItemClicked: RecyclerViewItemClicked
) : RecyclerView.Adapter<ChatsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_chats_layout, parent, false)
        return ChatsViewHolder(view, recyclerViewItemClicked)

    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        val users = usersList[position]
        holder.setData(users)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

}