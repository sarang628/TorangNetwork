package com.sarang.torang

import androidx.test.runner.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiMenu
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ApiMenuTest {
    // @formatter:off
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiMenu: ApiMenu
    // @formatter:on

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        //loginRepository.encEmailLogin("sry_ang@naver.com", "Torang!234")
    }

    @Test
    fun getAllRestaurantTest() = runTest {
        val result = apiMenu.findByRestaurantId(362)
        println(GsonBuilder().setPrettyPrinting().create().toJson(result))
        assert(!result.isEmpty())
    }

}