package com.example.whatsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.RecyclerViewItemClicked
import com.example.whatsapp.data.Users
import kotlinx.android.synthetic.main.recycler_chats_layout.view.*

class ChatsViewHolder(
    private val view: View,
    private val recyclerViewItemClicked: RecyclerViewItemClicked
) : RecyclerView.ViewHolder(view){

    fun setData(users: Users){
        view.apply {

            tvUserName.text = users.profileName
            llUsers.setOnClickListener {
                recyclerViewItemClicked.onItemClicked(adapterPosition,users)
            }
        }
    }
}