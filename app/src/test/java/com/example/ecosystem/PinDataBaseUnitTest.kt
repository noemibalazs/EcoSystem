package com.example.ecosystem

import com.example.ecosystem.data.entity.Pin
import com.example.ecosystem.data.entity.ProfileImage
import com.example.ecosystem.data.entity.Urls
import com.example.ecosystem.data.entity.User
import com.example.ecosystem.room.PinDAO
import com.example.ecosystem.room.PinDataBase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest= Config.NONE)
class PinDataBaseUnitTest {

    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()

    @Mock
    val mockPinDao: PinDAO? = null

    @Mock
    val mockMyDatabase: PinDataBase? = null


    @Before
    fun setUp() {
        Mockito.`when`(mockMyDatabase!!.getPinDao()).thenReturn(mockPinDao)
    }


    @Test
    @Throws(Exception::class)
    fun addEntityTest(){
        val profile = ProfileImage("small", "medium", "large")
        val user = User("9", "Joe", profile )
        val urls = Urls("raw", "full", "regular", "small", "thumb")
        val pin = Pin("12", 120, 360, user, urls)
        val id = mockPinDao?.addPin2DB(pin)
        Assert.assertNotNull(id)
    }
}