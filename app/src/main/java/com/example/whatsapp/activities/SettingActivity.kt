package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.whatsapp.R

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val llInviteFriend = findViewById<LinearLayout>(R.id.llInviteFriend)
        llInviteFriend.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Let's chat on WhatsApp! It's a fast, simple, and secure app we can use to message and call each other for free. Get it at https://whatsapp.com/dl/"
            );
            startActivity(
                Intent.createChooser(
                    shareIntent,
                    getString(R.string.share_whatsapp_text)
                )
            )
        }

        val llHelpSettings = findViewById<LinearLayout>(R.id.llHelpSettings)
        llHelpSettings.setOnClickListener {
            val helpIntent = Intent(this@SettingActivity, HelpActivity::class.java)
            startActivity(helpIntent)
        }

        val ivArrow = findViewById<ImageView>(R.id.ivSettingsArrow)
        ivArrow.setOnClickListener {
            val homeIntent = Intent(this@SettingActivity, HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }
}