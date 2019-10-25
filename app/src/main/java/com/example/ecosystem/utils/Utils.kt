package com.example.ecosystem.utils

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.ecosystem.data.entity.Pin


fun View.setOnDebounceClickListener(clicked: (View) -> Unit){
    this.setOnClickListener(object : DebounceClickListener(){
        override fun onDebounce(v: View) {
            clicked(v)
        }
    })
}

fun Context.openNewActivity(dest: Class<*>){
    this.startActivity(Intent(this, dest))
}