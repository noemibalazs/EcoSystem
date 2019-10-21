package com.example.ecosystem.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecosystem.data.converter.UrlsConverter
import com.example.ecosystem.data.converter.UserConverter
import com.example.ecosystem.data.entity.Pin

@Database(entities = [Pin::class], version = 2, exportSchema = false)
@TypeConverters(UrlsConverter::class, UserConverter::class)
abstract class PinDataBase: RoomDatabase() {
    abstract fun getPinDao():PinDAO
}