package com.example.whatsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Status_1
import kotlinx.android.synthetic.main.item_status.view.*

class StatusViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

    fun setData(status1: Status_1) {
      view.apply {
       status_img.setImageResource(R.drawable.john_1)
         status_name.text = status1.status_name
      }
    }
}