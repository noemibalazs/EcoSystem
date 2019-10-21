package com.example.ecosystem.viewmodel

import androidx.lifecycle.LiveData
import com.example.ecosystem.data.entity.PinList
import com.example.ecosystem.repository.PinRepository

class PinViewModel(val repo: PinRepository) : BasePinViewModel() {

    override fun getPinList(): LiveData<PinList> {
        return repo.fetchList { repo.pinService.getPinList() }
    }
}