package com.example.whatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.whatsapp.R
import com.example.whatsapp.data.Users
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        auth = Firebase.auth
        nextHomeBtn.setOnClickListener {
            if (profileAbout.text.isEmpty() || profileNameUser.text.isEmpty()) {
                Toast.makeText(this@UserDataActivity, "Invalid Entry", Toast.LENGTH_LONG).show()

            } else {
                updateFirebaseDatabase()
            }
        }

    }

    private fun updateFirebaseDatabase() {
        val userId = auth.currentUser?.uid!!
        databaseReference =
            FirebaseDatabase.getInstance().getReference("Users").child(userId)
        val user = Users(
            profileNameUser.text.toString(),
            this.auth.currentUser?.phoneNumber.toString(),
            profileAbout.text.toString(),
            auth.uid
        )
        //Adds the user to the database
        databaseReference.setValue(user).addOnCompleteListener {
            val intent = Intent(this@UserDataActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
