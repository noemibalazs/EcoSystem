package com.example.ecosystem.room

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecosystem.data.converter.UrlsConverter
import com.example.ecosystem.data.converter.UserConverter
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.utils.PIN_DB

@Database(entities = [Pin::class], version = 4, exportSchema = false)
@TypeConverters(UrlsConverter::class, UserConverter::class)
abstract class PinDataBase: RoomDatabase() {
    abstract fun getPinDao():PinDAO

    companion object{

        var INSTANCE: PinDataBase?=null

        fun getDataBase(context: Context):PinDataBase{
            if (INSTANCE == null){
                synchronized(PinDataBase::class.java){
                    INSTANCE = Room.databaseBuilder(context, PinDataBase::class.java, PIN_DB).build()
                }
            }
            return INSTANCE!!
        }
    }
}