package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.whatsapp.AccountActivity
import com.example.whatsapp.NotificationActivity
import com.example.whatsapp.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        account_layout.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,AccountActivity::class.java)
            startActivity(intent)

        })
        notification_layout.setOnClickListener(View.OnClickListener {
            val intent1=Intent(this,NotificationActivity::class.java)
            startActivity(intent1)
        })
        help_layout.setOnClickListener(View.OnClickListener {
         //   val intent=Intent(this,Help::class.java)
           // startActivity(intent)
        })


    }
}