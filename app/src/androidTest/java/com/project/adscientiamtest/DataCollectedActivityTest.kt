package com.project.adscientiamtest

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.project.adscientiamtest.datacollected.DataCollectedActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataCollectedActivityTest {


    @Rule
    @JvmField
    val mDataCollectedRule = ActivityTestRule(DataCollectedActivity::class.java)

    @Test
    fun recyclerViewIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun menuIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.delete_all_data))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}