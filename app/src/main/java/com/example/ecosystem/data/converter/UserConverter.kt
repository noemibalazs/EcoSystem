package com.example.ecosystem.data.converter

import androidx.room.TypeConverter
import com.example.ecosystem.data.entity.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserConverter {

    @TypeConverter
    fun fromUser2String(user: User?): String?{
        if (user == null) return null
        return Gson().toJson(user)
    }

    @TypeConverter
    fun toUserFromString(key:String?): User? {
        if (key == null) return null
        val type = object : TypeToken<User>(){}.type
        return Gson().fromJson<User>(key, type)
    }
}