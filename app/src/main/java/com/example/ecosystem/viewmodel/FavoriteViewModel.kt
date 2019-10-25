package com.example.ecosystem.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.room.PinDataBase

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    fun getPinList(): LiveData<MutableList<Pin>> {
        val db = PinDataBase.getDataBase(getApplication())
        return db.getPinDao().getPinList()
    }
}