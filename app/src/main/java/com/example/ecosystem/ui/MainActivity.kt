package com.example.ecosystem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecosystem.R
import com.example.ecosystem.adapter.CustomPagerAdapter
import com.example.imagelibrary.GlideApp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pin_item.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       myViewPager.adapter = CustomPagerAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(myViewPager)
    }
}
