package com.example.ecosystem.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ecosystem.R
import com.example.ecosystem.fragment.FavoriteFragment
import com.example.ecosystem.fragment.PinsFragment
import com.example.ecosystem.utils.ZERO

class CustomPagerAdapter(val context: Context, val manager: FragmentManager) :
    FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            ZERO -> { PinsFragment()
            }
            else -> { FavoriteFragment() }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            ZERO -> { context.getString(R.string.pin_list)}
            else -> { context.getString(R.string.favorite)}
        }
    }
}