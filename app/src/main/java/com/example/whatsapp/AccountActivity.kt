package com.example.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.whatsapp.activities.SettingActivity
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        profile_backarrow1.setOnClickListener(View.OnClickListener {
           val intent=Intent(this,SettingActivity::class.java)
            startActivity(intent)
        })
    }
}