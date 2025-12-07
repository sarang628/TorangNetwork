package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.feed.ApiFeedV1
import com.sarang.torang.data.remote.response.FavoriteFeedApiModel
import com.sarang.torang.data.remote.response.LoginApiModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
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
    @Inject lateinit var apiLogin: ApiLogin
    @Before fun setUp() { hiltRule.inject() }

    val tag = "__ApiFeedV1Test"

    val Omnivore_by_Sharkys = 299


    @Test
    fun pageTest() = runTest {
        val result = apiFeedV1.findByPage(null, 1)
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun userFeedsTest() = runTest {
        val result = apiFeedV1.findByTokenAndId(null, 425)
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
        val result = apiFeedV1.findByRestaurantId(null, Omnivore_by_Sharkys)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun findByUserAndRestaurantId() = runTest {
        val result = apiFeedV1.findByUserAndRestaurantId(null, 1, Omnivore_by_Sharkys)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun findByUserIdTest() = runTest {
        val result = apiFeedV1.findByUserId(null, 1)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun findByFavoriteTest() = runTest {
        val resultLogin : LoginApiModel = apiLogin.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234"))
        val resultFavorite : List<FavoriteFeedApiModel> = apiFeedV1.findByFavorite(resultLogin.token)
        Log.d(tag, GsonBuilder().setPrettyPrinting().create().toJson(resultFavorite))
        assertEquals(true, resultFavorite.isNotEmpty())
    }

    @Test
    fun findByLikeTest() = runTest {
        val resultLogin = apiLogin.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234"))
        val resultFavorite = apiFeedV1.findByLike(resultLogin.token)
        assertEquals(true, resultFavorite.isNotEmpty())
    }
}