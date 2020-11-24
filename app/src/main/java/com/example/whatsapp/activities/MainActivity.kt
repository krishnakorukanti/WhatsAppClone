package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.whatsapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(),CountryCodePicker.OnCountryChangeListener{
    private var ccp:CountryCodePicker?=null
    private var countryCode:String?=null
    private var countryName:String?=null
    private var phone_number: String? = null
    private var otp: String? = null
    private lateinit var auth: FirebaseAuth
    private var VerificationCode: String?=null
    private lateinit var ResendForce:PhoneAuthProvider.ForceResendingToken
    private  var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ccp = findViewById(R.id.country_code_picker)
        ccp!!.setOnCountryChangeListener(this)
        ccp!!.setDefaultCountryUsingNameCode("JP")



        btn_otp.setOnClickListener(View.OnClickListener {
            countryCode = country_code_picker.textView_selectedCountry.toString()
            phone_number = et_phone_number.text.toString()
            auth = FirebaseAuth.getInstance()
            if (countryCode!!.isEmpty() || phone_number!!.isEmpty()) {
                tv_error.text = "Fill the Form to Continue"
                tv_error.visibility = View.VISIBLE
                btn_otp.isEnabled = false

            } else {

                btn_otp.isEnabled = true
                val options = PhoneAuthOptions.newBuilder(auth)
                    .setPhoneNumber(phone_number!!)       // Phone number to verify
                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                    .setActivity(this)                 // Activity (for callback binding)
                    .setCallbacks(mCallback!!)          // OnVerificationStateChangedCallbacks
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
            }
        })
        btn_sign_in.setOnClickListener(View.OnClickListener {
            otp = et_otp.text.toString()
            val credential = PhoneAuthProvider.getCredential(VerificationCode!!, otp!!)
            SigninWithPhone(credential);
        })
        mCallback  = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                SigninWithPhone(phoneAuthCredential);
                Toast.makeText(this@MainActivity, "verification completed", Toast.LENGTH_SHORT).show();
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(this@MainActivity, "verification failed", Toast.LENGTH_SHORT).show();
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                VerificationCode = p0
                ResendForce = p1
                Toast.makeText(this@MainActivity, "Code sent", Toast.LENGTH_SHORT).show();
            }

        }







    }

    private fun SigninWithPhone(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(OnCompleteListener<AuthResult>() {
                if (it.isSuccessful){
                    startActivity(Intent(this@MainActivity,MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this@MainActivity,"Incorrect OTP",Toast.LENGTH_SHORT).show()
                }
            });

    }




    override fun onCountrySelected() {
        countryCode=ccp!!.selectedCountryCode
        countryName=ccp!!.selectedCountryName

        Toast.makeText(this, "Country Code " + countryCode, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Country Name " + countryName, Toast.LENGTH_SHORT).show()
    }

}
