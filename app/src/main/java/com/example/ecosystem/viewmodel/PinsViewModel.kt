package com.example.ecosystem.viewmodel

import androidx.lifecycle.LiveData
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.repository.PinRepository

class PinsViewModel(val repo: PinRepository) : BasePinViewModel() {

    override fun getPinList(): LiveData<MutableList<Pin>> {
        return repo.fetchList { repo.pinService.getPinList() }
    }
}