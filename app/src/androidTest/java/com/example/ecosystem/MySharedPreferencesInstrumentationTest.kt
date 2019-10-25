package com.example.ecosystem

import android.content.Context
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.ecosystem.helper.MySharedPrefHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MySharedPreferencesInstrumentationTest {

    private var shredHelper: MySharedPrefHelper?=null
    private val TEST = "test"

    @Before
    fun createHelper(){
        shredHelper = MySharedPrefHelper(
            InstrumentationRegistry.getInstrumentation().context)
    }

    @Test
    fun addValueTest(){
        shredHelper?.savePinId(TEST)
        val testId = shredHelper?.getPinId()
        Assert.assertEquals(testId, TEST)
    }


}