package com.example.ecosystem

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.ecosystem.ui.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityInstrumentationTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun viewPagerSwiped(){
        onView(withId(R.id.myViewPager)).perform(swipeLeft()).check(matches(isDisplayed()))
    }

    @Test
    fun tabLayoutDisplayed(){
       onView(withId(R.id.tabLayout)).perform(click()).check(matches(isDisplayed()))
    }

    @Test
    fun contextText(){
        val context = InstrumentationRegistry.getInstrumentation().context
        Assert.assertEquals("com.example.ecosystem.test", context.packageName)
    }

}