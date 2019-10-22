package com.example.ecosystem.custom

import android.content.Context
import android.text.TextUtils
import com.example.ecosystem.data.entity.Pin
import com.example.imagelibrary.CustomPreLoader
import java.util.*


class CustomPreLoadModelProvider(val pinList: MutableList<Pin>, context: Context) : CustomPreLoader<Any>(context){

    override fun getPreloadItems(position: Int): MutableList<Any> {
        val url  = pinList[position].urls.regular
        if (TextUtils.isEmpty(url)){
           return Collections.emptyList()
        }
        return Collections.singletonList(url)
    }
}