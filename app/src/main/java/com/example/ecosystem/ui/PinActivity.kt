package com.example.ecosystem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ecosystem.R
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.helper.MySharedPrefHelper
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.room.PinDataBase
import com.example.imagelibrary.GlideApp
import kotlinx.android.synthetic.main.activity_pin.*

class PinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)

        val pref = MySharedPrefHelper(this)
        val id = pref.getPinId()

        val observer = object:Observer<Pin>{
            override fun onChanged(pin: Pin?) {
               pin?.let {
                   populateUI(it)
               }
            }

        }

        PinDataBase.getDataBase(this).getPinDao().getPin(id).observe(this, observer)
    }

    private fun populateUI(pin:Pin){
        Glide.with(this)
            .load(pin.urls.regular)
            .placeholder(R.drawable.cover)
            .error(R.drawable.cover)
            .into(coverPin)

        pinOwner.text = String.format(getString(R.string.saved), pin.user.name)

        val profile = pin.user.profileImage.small
        Glide.with(this)
            .load(profile)
            .placeholder(R.drawable.circle)
            .error(R.drawable.circle)
            .apply(RequestOptions.circleCropTransform())
            .into(ownerAvatar)

    }
}
