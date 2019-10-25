package com.example.ecosystem.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ecosystem.data.entity.Pin

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

}