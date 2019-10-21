package com.example.ecosystem.data.entity

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("profile_image") val profileImage: ProfileImage
)