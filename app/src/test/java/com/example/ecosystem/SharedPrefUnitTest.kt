package com.example.ecosystem

import android.content.Context
import com.example.ecosystem.helper.MySharedPrefHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest= Config.NONE)
class SharedPrefUnitTest {

    private var sharedHelper: MySharedPrefHelper?=null
    private val TEST = "test"

    @Before
    fun createSharedPref() {
        val context = RuntimeEnvironment.application.applicationContext
        sharedHelper = MySharedPrefHelper(context)
    }

    @Test
    fun addSymbol() {
        sharedHelper?.savePinId(TEST)
        val testId = sharedHelper?.getPinId()
        Assert.assertEquals(testId, TEST)

    }
}