package com.example.ecosystem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.ecosystem.R
import com.example.ecosystem.adapter.EndlessRecyclerOnScrollListener
import com.example.ecosystem.adapter.PinAdapter
import com.example.ecosystem.network.PinService
import com.example.ecosystem.repository.PinRepository
import com.example.ecosystem.viewmodel.PinViewModel
import kotlinx.android.synthetic.main.fragment_container.*


class PinsFragment : Fragment() {

    private lateinit var pinViewModel:PinViewModel
    private lateinit var adapter: PinAdapter
    private lateinit var pinRepository: PinRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pinRepository = PinRepository(PinService.getPinService())
        pinViewModel = PinViewModel(pinRepository)

        initRV()
        getPinList()
    }


    private fun initRV() {
        pinRecycleView.setHasFixedSize(true)
        val manager = pinRecycleView.layoutManager as GridLayoutManager
        pinRecycleView.addOnScrollListener(object: EndlessRecyclerOnScrollListener(manager){
            override fun onLoadMore(page: Int) {
                getPinList()
            }
        })
    }

    private fun getPinList(){
        val request = pinViewModel.getPinList()
        request.observe(this, Observer {
            adapter = PinAdapter(it, activity!!.applicationContext)
            pinRecycleView.adapter = adapter
        })
    }
}
