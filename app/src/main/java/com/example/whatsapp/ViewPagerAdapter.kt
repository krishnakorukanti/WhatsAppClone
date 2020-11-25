package com.example.whatsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.whatsapp.fragments.CallsFragment
import com.example.whatsapp.fragments.ChatsFragment
import com.example.whatsapp.fragments.StatusFragment
import java.util.*

class ViewPagerAdapter(
    fragmentManager: FragmentManager, private val fragmentList: List<Fragment?>? = ArrayList(),
    private val fragmentTitles: List<String?>? = ArrayList()

) :FragmentStatePagerAdapter(fragmentManager) {



    override fun getCount(): Int {
      return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                  return ChatsFragment()
            }
            1 -> {
                return StatusFragment()
            }
            2 -> {
                return CallsFragment()
            }
            else -> {
                return CallsFragment()
            }
        }
        return CallsFragment()

    }

    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
            0 ->{
                return "Chats"
            }
            1->{
                return "status"
            }
            2->{
                return "calls"
            }
        }
        return super.getPageTitle(position)
    }

}