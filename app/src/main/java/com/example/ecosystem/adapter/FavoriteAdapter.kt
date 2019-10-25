package com.example.ecosystem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecosystem.R
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.helper.MySharedPrefHelper
import com.example.ecosystem.ui.FavoriteActivity
import com.example.ecosystem.utils.openNewActivity
import com.example.ecosystem.utils.setOnDebounceClickListener

class FavoriteAdapter(val pinList: MutableList<Pin>, val context: Context) : RecyclerView.Adapter<FavoriteAdapter.FavoriteVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pin_item, parent, false)
        return FavoriteVH(view)
    }

    override fun getItemCount(): Int {
        return pinList.size
    }

    override fun onBindViewHolder(holder: FavoriteVH, position: Int) {

        val pref = MySharedPrefHelper(context)

        val pin = pinList[position]

        Glide.with(context).load(pin.urls.regular).placeholder(R.drawable.cover)
            .error(R.drawable.cover).into(holder.avatar)

        holder.itemView.setOnDebounceClickListener {
            pref.savePinId(pin.id)
            context.openNewActivity(FavoriteActivity::class.java)
        }
    }

    inner class FavoriteVH(view: View) : RecyclerView.ViewHolder(view) {
        val avatar = view.findViewById<ImageView>(R.id.pinAvatar)
    }
}
