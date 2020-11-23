package com.example.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
 private val SPLACH_TIME:Long=3000//1 sec


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
Handler().postDelayed({
    startActivity(Intent(this,MainActivity::class.java))
    finish()
}
,SPLACH_TIME)
    }
}