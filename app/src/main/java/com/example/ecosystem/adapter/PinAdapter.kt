package com.example.ecosystem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecosystem.R
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.utils.loadPicture

class PinAdapter(val pinList: MutableList<Pin>) : RecyclerView.Adapter<PinAdapter.PinVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pin_item, parent, false)
        return PinVH(view)
    }

    override fun getItemCount(): Int {
        return pinList.size
    }

    override fun onBindViewHolder(holder: PinVH, position: Int) {
        val pin = pinList[position]
        loadPicture(holder.avatar, pin.urls.regular)
    }

    inner class PinVH(view: View) : RecyclerView.ViewHolder(view) {
        val avatar = view.findViewById<ImageView>(R.id.pinAvatar)
    }
}