package com.sarang.torang

import androidx.test.runner.AndroidJUnit4
import com.sarang.torang.api.ApiFilter
import com.sarang.torang.data.remote.response.FilterApiModel
import com.sarang.torang.data.remote.response.RatingApiModel
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
    fun getCitiesTest() = runTest {
        val result = apiFilter.getCities()
        prettyPrint(result)
    }

    @Test
    fun getCitiesByNationIdTest() = runTest {
        val result = apiFilter.getCitiesByNationId(1)
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun getNationsTest() = runTest {
        val result = apiFilter.getNations()
        Assert.assertEquals(result.isNotEmpty(), true)
    }


    @Test
    fun aroundRestaurantTest() = runTest {
        val result = apiFilter.aroundRestaurant(FilterApiModel())
        prettyPrint(result)
    }

    @Test
    fun aroundRestaurantTest1() = runTest {
        val result = apiFilter.aroundRestaurant(FilterApiModel(
            ratings = listOf(RatingApiModel.ONE, RatingApiModel.TWO, RatingApiModel.THREE, RatingApiModel.FIVE, RatingApiModel.FOUR)
        ))
        prettyPrint(result)
    }

    @Test
    fun boundRestaurantTest() = runTest {
        apiFilter.boundRestaurant(FilterApiModel())
    }
}