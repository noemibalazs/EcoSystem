package com.example.ecosystem.data.entity

import com.google.gson.annotations.SerializedName

data class Urls(
    @field:SerializedName("raw") val raw:String,
    @field:SerializedName("full") val full:String,
    @field:SerializedName("regular") val regular:String,
    @field:SerializedName("small") val small:String,
    @field:SerializedName("thumb") val thumb:String
)