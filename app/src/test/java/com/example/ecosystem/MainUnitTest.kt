package com.example.ecosystem

import androidx.viewpager.widget.ViewPager
import com.example.ecosystem.adapter.CustomPagerAdapter
import com.example.ecosystem.ui.MainActivity
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest= Config.NONE)
class MainUnitTest {

    private var pager: ViewPager? = null
    private var adapter: CustomPagerAdapter?=null

    private var mainActivity: MainActivity?=null

    @Before
    fun create(){
        mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().resume().get()
        val manager = mainActivity?.supportFragmentManager
        val context = RuntimeEnvironment.application.applicationContext
        pager = mainActivity!!.findViewById(R.id.myViewPager) as ViewPager
        adapter = CustomPagerAdapter(context, manager!!)
    }

    @Test
    @Throws(Exception::class)
    fun shouldSetAndGetAdapter() {
        pager!!.adapter = adapter
        assertSame(adapter, pager!!.adapter)
    }

    @Test
    @Throws(Exception::class)
    fun test_getAndSetCurrentItem() {
        pager!!.currentItem = 1
        assertEquals(1, pager!!.currentItem)
    }
}