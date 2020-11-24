package com.example.whatsapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_verify_otp.*
import java.util.concurrent.TimeUnit

class VerifyOtpActivity : AppCompatActivity() {
    private var phoneNumberRec: String? = null
    private lateinit var auth: FirebaseAuth
    private var verificationCode: String? = null
    private var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_otp)
        val phoneNum: String = intent.getStringExtra("phone").toString()
        tvVerifiedPhoneNumber.text = phoneNum
        numInText.text = phoneNum
        phoneNumberRec = phoneNum
        sendVerificationCode()
        otpSumbitBtn.setOnClickListener {
            if (tvInputOtp.text.isEmpty()){
                tvInputOtp.error = "Invalid OTP"
            }else{
                verifyCode(tvInputOtp.text.toString())
            }
        }

    }

    private val mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                verificationCode = p0

            }

            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                val code: String? = p0.smsCode
                if (code != null) {
                    verifyCode(code)
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(
                    this@VerifyOtpActivity,
                    "verification failed - ${p0.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    private fun verifyCode(code: String) {
        val credential: PhoneAuthCredential =
            PhoneAuthProvider.getCredential(verificationCode.toString(), code)
        siginTheUserByCredntials(credential)
    }

    private fun siginTheUserByCredntials(credential: PhoneAuthCredential) {

        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(OnCompleteListener<AuthResult>() {
                if (it.isSuccessful) {
                    Toast.makeText(this@VerifyOtpActivity, "Otp verification Successful", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@VerifyOtpActivity,UserDataActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@VerifyOtpActivity, "FAIL", Toast.LENGTH_LONG).show()
                }
            })

    }


    private fun sendVerificationCode() {
        if (phoneNumberRec != null) {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91$phoneNumberRec",
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks
            )
        }


    }
}