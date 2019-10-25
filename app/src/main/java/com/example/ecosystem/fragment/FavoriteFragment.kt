package com.example.ecosystem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.ecosystem.R
import com.example.ecosystem.adapter.FavoriteAdapter
import com.example.ecosystem.adapter.PinAdapter
import com.example.ecosystem.repository.PinRepository
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.viewmodel.PinViewModel
import kotlinx.android.synthetic.main.fragment_container.*

class FavoriteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRV()
        populateUI()
    }

    private fun initRV(){
        pinRecycleView.setHasFixedSize(true)
    }

    private fun populateUI(){
        val pinList = PinDAO.getPinDao(activity!!.applicationContext).getPinList()
        pinList.observe(this, Observer {
            val adapter = FavoriteAdapter(it, activity!!.applicationContext)
            pinRecycleView.adapter = adapter
        })
    }

}
