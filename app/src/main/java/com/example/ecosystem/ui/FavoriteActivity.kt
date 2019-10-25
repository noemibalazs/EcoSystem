package com.example.ecosystem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ecosystem.R
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.helper.MySharedPrefHelper
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.room.PinDataBase
import kotlinx.android.synthetic.main.activity_favorite.*
import org.jetbrains.anko.doAsync

class FavoriteActivity : AppCompatActivity() {

    private lateinit var entity: Pin
    private lateinit var db: PinDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val pref = MySharedPrefHelper(this)
        val id = pref.getPinId()

        db = PinDataBase.getDataBase(this)

        val observer = object : Observer<Pin> {
            override fun onChanged(pin: Pin?) {
                pin?.let {
                    populateUI(it)
                    entity = it
                }
            }

        }

        db.getPinDao().getPin(id).observe(this, observer)
    }

    private fun populateUI(pin: Pin) {
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
            .apply(RequestOptions.circleCropTransform())
            .into(favOwnerAvatar)

    }

    private fun deletePinFromDB(pin: Pin) {
        doAsync {
            db.getPinDao().deletePin(pin)
        }
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.delete) {
            deletePinFromDB(entity)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
