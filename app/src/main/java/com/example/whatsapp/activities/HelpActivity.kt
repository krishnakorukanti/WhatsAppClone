package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.whatsapp.R

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val ivHelpArrow = findViewById<ImageView>(R.id.ivHelpArrow)
        ivHelpArrow.setOnClickListener {
            val settingsIntent = Intent(this@HelpActivity, SettingActivity::class.java)
            startActivity(settingsIntent)
        }

        val llFAQ = findViewById<LinearLayout>(R.id.llFaq)
        llFAQ.setOnClickListener {
            val fAQIntent = Intent(this@HelpActivity, FAQActivity::class.java)
            startActivity(fAQIntent)
        }
    }
}