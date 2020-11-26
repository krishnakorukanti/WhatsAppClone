package com.example.whatsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.StatusModel
import kotlinx.android.synthetic.main.item_status.view.*

class StatusViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

    fun setData(status: StatusModel) {
        view.apply {
            statusUserImage.setImageResource(R.drawable.john)
           statusUserName.text = status.status_name
        }
    }
}