package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.whatsapp.R
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CountryCodePicker.OnCountryChangeListener{
    private var ccp:CountryCodePicker?=null
    private var countryCode:String?=null
    private var countryName:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ccp = findViewById(R.id.country_code_picker)
        ccp!!.setOnCountryChangeListener(this)
        ccp!!.setDefaultCountryUsingNameCode("JP")
        btn_otp.setOnClickListener(View.OnClickListener {
             val intent = Intent(this@MainActivity, ProfileActivity::class.java)
               startActivity(intent)
        })

    }

    override fun onCountrySelected() {
        countryCode=ccp!!.selectedCountryCode
        countryName=ccp!!.selectedCountryName

        Toast.makeText(this,"Country Code "+countryCode,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Country Name "+countryName,Toast.LENGTH_SHORT).show()
    }



    }
