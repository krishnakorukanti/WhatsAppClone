package com.example.whatsapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import com.example.whatsapp.R
import com.example.whatsapp.ViewPagerAdapter
import com.example.whatsapp.adapter.CallsAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        view_pager.adapter = ViewPagerAdapter(supportFragmentManager)

        tabs.setupWithViewPager(view_pager)



       /* setViewPagerAdapter()
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)
        toolbar?.title = "WhatsApp"
*/
    }

   /* private fun setViewPagerAdapter() {

    }*/

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }*/
}