package com.example.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.whatsapp.activities.SettingActivity
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        profile_backarrow_notification.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,SettingActivity::class.java)
            startActivity(intent)
        })


    }
}