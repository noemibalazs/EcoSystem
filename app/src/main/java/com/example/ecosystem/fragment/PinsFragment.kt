package com.example.ecosystem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ecosystem.R
import com.example.ecosystem.custom.CustomPreLoadModelProvider
import com.example.ecosystem.data.entity.Pin
import com.example.imagelibrary.CustomGlideExtension
import com.example.imagelibrary.getRecycleViewPreLoader
import com.example.imagelibrary.getSizeProvider

class PinsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }


    private fun init(pinList:MutableList<Pin>){
        val size = 100
        val maxPreload = 10
        val sizeProvider = getSizeProvider(size, size)
        val modelProvider = CustomPreLoadModelProvider(pinList, activity!!.applicationContext)
        val preLoader = getRecycleViewPreLoader(this, modelProvider= modelProvider ,
            sizeProvider = sizeProvider, maxNumber = maxPreload)
    }
}
