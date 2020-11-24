package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatsapp.R
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        nextPhnBtn.setOnClickListener {
            if (tvPhoneNumber.text.length<10){
                tvPhoneNumber.error = "Invalid Number"

            }else{
                val intent = Intent(this@LogInActivity,VerifyOtpActivity::class.java)
                intent.putExtra("phone",tvPhoneNumber.text.toString())
                startActivity(intent)
            }
        }
    }
}