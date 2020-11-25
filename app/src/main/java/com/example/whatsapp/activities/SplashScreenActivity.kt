package com.example.whatsapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapp.AccountActivity
import com.example.whatsapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val SPLACH_TIME: Long = 3000//1 sec


    override fun onCreate(savedInstanceState: Bundle?) {
       auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(mainLooper).postDelayed({

            /* Check if the user is already signed In, If yes directly show me all the participants screen
            or else navigate him to Login screen
            */
           if (auth.currentUser != null) {
                val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                startActivity(intent)
           } else {
                val intent = Intent(this@SplashScreenActivity, LogInActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 3000)
    }
}
