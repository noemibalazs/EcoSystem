package com.example.ecosystem.data.converter

import androidx.room.TypeConverter
import com.example.ecosystem.data.entity.Urls
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UrlsConverter {

    @TypeConverter
    fun fromUrls2String(urls: Urls?) : String?{
        if (urls == null) return null
        return Gson().toJson(urls)
    }

    @TypeConverter
    fun toUrlsFromString(key: String?): Urls? {
        if (key == null) return null
        val type = object : TypeToken<Urls>(){}.type
        return Gson().fromJson<Urls>(key, type)
    }
}