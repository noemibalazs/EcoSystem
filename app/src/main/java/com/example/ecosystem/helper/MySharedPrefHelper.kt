package com.example.ecosystem.helper

import android.content.Context
import com.example.ecosystem.utils.KEY_ID

class MySharedPrefHelper(val context:Context) {

    val pref = context.getSharedPreferences("My pref", Context.MODE_PRIVATE)

    fun savePinId(id:String){
        pref.edit().putString(KEY_ID, id).apply()
    }

    fun getPinId(): String = pref.getString(KEY_ID, "")
}