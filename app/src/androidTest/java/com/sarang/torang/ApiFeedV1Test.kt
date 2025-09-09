package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.feed.ApiFeedV1
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
class ApiFeedV1Test {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiFeedV1: ApiFeedV1
    @Before fun setUp() { hiltRule.inject() }

    @Test
    fun findAllTest() = runTest {
        val result = apiFeedV1.findAll(null)
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun pageTest() = runTest {
        val result = apiFeedV1.page(null, 1)
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun userFeedsTest() = runTest {
        val result = apiFeedV1.userFeeds(null, 425)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result != null, true)
    }

    @Test
    fun findByIdTest() = runTest {
        val result = apiFeedV1.findById(null, 425)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
    }

    @Test
    fun findNextByIdTest() = runTest {
        val result = apiFeedV1.findNextById(null, 425, 30)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun findByRestaurantIdTest() = runTest {
        val result = apiFeedV1.findByRestaurantId(null, 234)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun findByUserAndRestaurantId() = runTest {
        val result = apiFeedV1.findByUserAndRestaurantId(null, 1, 234)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun findByUserIdTest() = runTest {
        val result = apiFeedV1.findByUserId(null, 1)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }
}