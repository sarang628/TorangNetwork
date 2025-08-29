package com.sarang.torang

import android.util.Log
import androidx.test.runner.AndroidJUnit4
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiFilter
import com.sarang.torang.data.remote.response.FilterApiModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ApiFilterTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiFilter: ApiFilter
    @Before fun setUp() { hiltRule.inject() }

    @Test
    fun getNationsTest() = runTest {
        val result = apiFilter.getNations()
        Assert.assertEquals(result.isNotEmpty(), true)
    }


    @Test
    fun getCitiesByNationIdTest() = runTest {
        val result = apiFilter.getCitiesByNationId(1)
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun test() = runTest {
        var result = apiFilter.aroundRestaurant(FilterApiModel())
        Log.d("__test", GsonBuilder().setPrettyPrinting().create().toJson(result))
    }
}