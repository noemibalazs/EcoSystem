package com.example.ecosystem

import androidx.room.Room
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.data.entity.ProfileImage
import com.example.ecosystem.data.entity.Urls
import com.example.ecosystem.data.entity.User
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.room.PinDataBase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

@RunWith(AndroidJUnit4ClassRunner::class)
class PinDataBaseInstrumentationTest {

    private var db: PinDataBase?=null
    private var pinDAO: PinDAO?=null

    @Before
    fun createDataBase(){
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context,
            PinDataBase::class.java).build()
        pinDAO = db?.getPinDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDataBase(){
        db?.close()
    }

    @Test
    @Throws(Exception::class)
    fun addPin2DbTest(){
        val profile = ProfileImage("small", "medium", "large")
        val user = User("9", "Joe", profile )
        val urls = Urls("raw", "full", "regular", "small", "thumb")
        val pin = Pin("12", 120, 360, user, urls)
        val id = pinDAO?.addPin2DB(pin)
        assertNotNull(id)

    }

}