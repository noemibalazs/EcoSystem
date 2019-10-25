package com.example.ecosystem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.ecosystem.R
import com.example.ecosystem.adapter.FavoriteAdapter
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.room.PinDataBase
import com.example.ecosystem.viewmodel.FavoriteViewModel
import kotlinx.android.synthetic.main.fragment_container.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PinDataBase.getDataBase(context!!).getPinDao()
        initRV()
        populateUI()
    }

    private fun initRV(){
        pinRecycleView.setHasFixedSize(true)
    }

    private fun populateUI(){
        val viewModel = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)
        viewModel.getPinList().observe(this, Observer {
            val adapter = FavoriteAdapter(it, activity!!.applicationContext)
            pinRecycleView.adapter = adapter
            adapter.notifyDataSetChanged()
        })

    }

}
