package com.example.whatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Chats
import com.example.whatsapp.viewholder.ChatRecViewHolder
import com.example.whatsapp.viewholder.ChatSendViewHolder
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ChatScreenAdapter(private var chatsList: List<Chats>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val ITEM_TYPE_SENT = 1
    private val ITEM_TYPE_RECEIVED = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ITEM_TYPE_SENT -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.sender_chat_layout, parent, false)
                return ChatSendViewHolder(view)
            }

            ITEM_TYPE_RECEIVED -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.reciver_chat_layout, parent, false)
                return ChatRecViewHolder(view)
            }
        }
        throw IllegalStateException("No matching views found")


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chats = chatsList[position]
        if (holder is ChatSendViewHolder){
            holder.setData(chats)
        }else if (holder is ChatRecViewHolder){
            holder.setData(chats)
        }

    }

    override fun getItemCount(): Int {
        return chatsList.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (chatsList[position].sender == Firebase.auth.currentUser?.uid){
            ITEM_TYPE_SENT
        } else{
            ITEM_TYPE_RECEIVED
        }
    }
    fun updateList(chatsList: List<Chats>){
        this.chatsList = chatsList
        notifyDataSetChanged()
    }
}