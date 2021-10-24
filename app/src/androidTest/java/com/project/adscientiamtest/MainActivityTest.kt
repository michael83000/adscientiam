package com.project.adscientiamtest

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.project.adscientiamtest.datacollected.DataCollectedActivity
import com.project.adscientiamtest.mainactivity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    lateinit var mainActivity: MainActivity
    lateinit var dataCollectedActivity: DataCollectedActivity


    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Rule
    @JvmField
    val mDataCollectedRule = ActivityTestRule(DataCollectedActivity::class.java)

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        mainActivity = mActivityRule.activity
        dataCollectedActivity = mDataCollectedRule.activity

    }

    @Test
    fun appLaunchSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onLaunchCheckSquareViewIsDisplayed() {
        Espresso.onView(withId(R.id.viewDraggable))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun onLaunchMenuDataIsDisplayed() {
        Espresso.onView(withId(R.id.launch_data_collected_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



    @Test
    fun itemViewLaunchActivity() {
        Espresso.onView(withId(R.id.launch_data_collected_activity))
                .perform(ViewActions.click())
        val intent = Intent()
        mActivityRule.launchActivity(intent)

    }
}