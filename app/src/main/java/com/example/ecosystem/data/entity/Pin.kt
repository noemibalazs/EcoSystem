package com.example.ecosystem.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.ecosystem.data.converter.UrlsConverter
import com.example.ecosystem.data.converter.UserConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pin_table")
data class Pin(

    @PrimaryKey
    @field:SerializedName("id") val id: String,
    @field:SerializedName("width") val width: Int,
    @field:SerializedName("height") val height:Int,
    @TypeConverters(UserConverter::class)
    @field:SerializedName("user") var user: User,
    @TypeConverters(UrlsConverter::class)
    @field:SerializedName("urls") var urls: Urls

)