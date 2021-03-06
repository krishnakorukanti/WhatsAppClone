package com.example.whatsapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.whatsapp.R
import com.example.whatsapp.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        three_dot.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,SettingActivity::class.java)
            startActivity(intent)

        })

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        if (viewPager != null) {
            val adapter = ViewPagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }


        setViewPagerAdapter()
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)
        toolbar?.title = "WhatsApp"

    }

    private fun setViewPagerAdapter() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }

}