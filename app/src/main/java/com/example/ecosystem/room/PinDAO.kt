package com.example.ecosystem.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.utils.PIN_DB

@Dao
interface PinDAO {

    @Query("SELECT * FROM pin_table")
    fun getPinList(): LiveData<MutableList<Pin>>

    @Query("SELECT * FROM pin_table WHERE id =:id")
    fun getPin(id: String): LiveData<Pin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPin2DB(pin: Pin)

    @Delete
    fun deletePin(pin: Pin)


    companion object{
        fun getPinDao(context: Context): PinDAO{
            return Room.databaseBuilder(context, PinDataBase::class.java, PIN_DB).build().getPinDao()
        }
    }
}