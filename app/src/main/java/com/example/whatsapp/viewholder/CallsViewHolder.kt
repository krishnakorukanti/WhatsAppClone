package com.example.whatsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.CallsModel
import kotlinx.android.synthetic.main.item_call_layout.view.*

class CallsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(model: CallsModel) {
        view.apply {
            callUserImage.setImageResource(R.drawable.john)
            callUserName.text = model.name
            //   Glide.with(tv_Title.context).load(model.getURL()).into(img_Pic)

        }
    }
}