package com.example.ecosystem.data.entity

import com.google.gson.annotations.SerializedName

data class ProfileImage (
    @field:SerializedName("small") val small: String,
    @field:SerializedName("medium") val medium: String,
    @field:SerializedName("large") val large: String
)