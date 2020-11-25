package com.example.whatsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.whatsapp.fragments.CallsFragment
import com.example.whatsapp.fragments.ChatsFragment
import com.example.whatsapp.fragments.StatusFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager

) : FragmentStatePagerAdapter(fragmentManager) {

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
                return ChatsFragment()
            }
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> {
                return "CHATS"
            }
            1 -> {
                return "STATUS"
            }
            2 -> {
                return "CALLS"
            }
        }
        return super.getPageTitle(position)
    }

}