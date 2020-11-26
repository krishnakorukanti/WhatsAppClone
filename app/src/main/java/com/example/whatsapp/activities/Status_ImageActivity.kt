package com.example.whatsapp.activities

import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.whatsapp.R
import kotlinx.android.synthetic.main.status_image_layout.*

class Status_ImageActivity :AppCompatActivity() {
   // var str_1:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.status_image_layout)
        val intent = getIntent()
     var  str_1 =  intent.getStringExtra("image_pass")
         Glide.with(this).load(str_1).into(get_img)
    }
}