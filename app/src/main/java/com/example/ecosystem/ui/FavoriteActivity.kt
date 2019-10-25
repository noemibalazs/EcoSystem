package com.example.ecosystem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.ecosystem.R
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.helper.MySharedPrefHelper
import com.example.ecosystem.room.PinDAO
import kotlinx.android.synthetic.main.activity_favorite.*
import org.jetbrains.anko.doAsync

class FavoriteActivity : AppCompatActivity() {

    private lateinit var entity:Pin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val pref = MySharedPrefHelper(this)
        val id = pref.getPinId()

        val observer = object: Observer<Pin> {
            override fun onChanged(pin: Pin?) {
                pin?.let {
                    populateUI(it)
                    entity = it
                }
            }

        }

        PinDAO.getPinDao(this).getPin(id).observe(this, observer)
    }

    private fun populateUI(pin:Pin){
        Glide.with(this)
            .load(pin.urls.regular)
            .placeholder(R.drawable.cover)
            .error(R.drawable.cover)
            .into(avatarFavorite)

        favoriteOwner.text = String.format(getString(R.string.saved), pin.user.name)

        val profile = pin.user.profileImage.small
        Glide.with(this)
            .load(profile)
            .placeholder(R.drawable.circle)
            .error(R.drawable.circle)
            .into(favOwnerAvatar)

    }

    private fun deletePinFromDB(pin:Pin){
        doAsync {
            PinDAO.getPinDao(applicationContext).deletePin(pin)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id!=null && id == R.menu.delete_menu){
            deletePinFromDB(entity)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
