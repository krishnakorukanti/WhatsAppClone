package com.example.whatsapp.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapp.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    val CAMERA_REQUEST_CODE = 0
    var img:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)
        profile_name.setText("Shivraj")
        profilr_about.setText("Welcome ")
        profilr_phonenumber.setText("8904190446")
        camera.setOnClickListener(this)
        profile_name_edit.setOnClickListener(this)
        profile_aboutedit.setOnClickListener(this)
        profilr_phoneEdit.setOnClickListener(this)
image_profile.setOnClickListener(this)
        btn_profile_backarrow.setOnClickListener(this)
        show_image.setOnClickListener(this)
        image_profile.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.camera -> {
                val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (callCameraIntent.resolveActivity(packageManager) != null) {
                    startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
                }

            }
            R.id.image_profile -> {
                show_image.visibility = View.VISIBLE
               // show_image.setImageBitmap()
               // show_image.visibility = View.GONE

            }
            R.id.profile_name_edit -> {
                profile_name.text = null
                var name = profile_name.text
                profile_name.setText(name)


            }
            R.id.profile_aboutedit -> {
                profilr_about.text = null
                var about: String = profilr_about.text.toString()
                profilr_about.setText(about)

            }
            R.id.profilr_phoneEdit -> {
                profilr_phonenumber.setText("")
                var phone_number = profilr_phonenumber.text
                profilr_phonenumber.setText(phone_number)
            }
            R.id.btn_profile_backarrow ->{
                val intent1=Intent(this@ProfileActivity,SettingActivity::class.java)
                startActivity(intent1)
            }
//R.id.image_profile ->{
//    show_image.visibility=View.VISIBLE


        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent=Intent(this,SettingActivity::class.java)
        startActivity(intent)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    img= image_profile.setImageBitmap(data.extras?.get("data") as Bitmap).toString()
                    image_profile.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT)
            }
        }
    }

}