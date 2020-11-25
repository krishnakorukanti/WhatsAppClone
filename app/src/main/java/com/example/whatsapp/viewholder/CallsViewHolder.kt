package com.example.whatsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Calls_1
import kotlinx.android.synthetic.main.item_call_layout.view.*

class CallsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    fun setData(model: Calls_1) {
        view.apply {
          contact_img_2.setImageResource(R.drawable.john_1)
            contact_name_2.text = model.name
            //   Glide.with(tv_Title.context).load(model.getURL()).into(img_Pic)

        }
    }
}