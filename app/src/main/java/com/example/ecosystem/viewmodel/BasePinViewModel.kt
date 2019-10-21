package com.example.ecosystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ecosystem.data.entity.PinList

abstract class BasePinViewModel : ViewModel() {

    abstract fun getPinList():LiveData<PinList>
}