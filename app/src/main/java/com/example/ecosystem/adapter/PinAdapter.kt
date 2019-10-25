package com.example.ecosystem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecosystem.R
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.helper.MySharedPrefHelper
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.room.PinDataBase
import com.example.ecosystem.ui.PinActivity
import com.example.ecosystem.utils.openNewActivity
import com.example.ecosystem.utils.setOnDebounceClickListener
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.doAsync


class PinAdapter(val pinList: MutableList<Pin>, val context: Context) : RecyclerView.Adapter<PinAdapter.PinVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pin_item, parent, false)
        return PinVH(view)
    }

    override fun getItemCount(): Int {
        return pinList.size
    }

    override fun onBindViewHolder(holder: PinVH, position: Int) {

        val pref = MySharedPrefHelper(context)

        val pin = pinList[position]

        Glide.with(context).load(pin.urls.regular).placeholder(R.drawable.cover)
            .error(R.drawable.cover).into(holder.avatar)

        holder.itemView.setOnDebounceClickListener {
            pref.savePinId(pin.id)
            addEntity2DB(pin)
            context.openNewActivity(PinActivity::class.java)
            snackToast(holder.itemView)
        }
    }

    inner class PinVH(view: View) : RecyclerView.ViewHolder(view) {
        val avatar = view.findViewById<ImageView>(R.id.pinAvatar)
    }

    private fun addEntity2DB(pin:Pin){
        doAsync {
            PinDataBase.getDataBase(context).getPinDao().addPin2DB(pin)
        }
    }

    private fun snackToast(view: View){
        Snackbar.make(view, context.getString(R.string.favorite), Snackbar.LENGTH_LONG).show()
    }
}