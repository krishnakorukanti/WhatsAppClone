package com.example.whatsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.data.Chats
import kotlinx.android.synthetic.main.sender_chat_layout.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ChatSendViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(chats: Chats) {
        view.apply {
            tvChatMessage.text = chats.message
            val date = Date(chats.timeStamp.toLong())
            val formatter: DateFormat = SimpleDateFormat("HH:mm")
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            val dateFormatted: String = formatter.format(date)
            tvTime.text = dateFormatted
        }
    }
}