package com.example.ecosystem.utils

import android.widget.ImageView
import com.example.ecosystem.R
import com.example.imagelibrary.GlideApp

fun loadPicture(view: ImageView, url: String){
    GlideApp.with(view.context)
        .load(url)
        .placeholder(R.drawable.cover)
        .error(R.drawable.cover)
        .into(view)
}