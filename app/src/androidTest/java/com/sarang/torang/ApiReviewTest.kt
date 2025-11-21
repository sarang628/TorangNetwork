package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiChat
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.ApiReview
import com.sarang.torang.api.ApiReviewV1
import com.sarang.torang.session.SessionService
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
class ApiReviewTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiReview: ApiReview
    @Inject lateinit var apiReviewV1: ApiReviewV1
    @Inject lateinit var sessionService: SessionService
    @Inject lateinit var login: ApiLogin

    val tag = "__ApiReviewTest"

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        val result = login.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234"))
        sessionService.saveToken(result.token);
    }

    @Test
    fun getReviewsByRestaurantId() = runTest {
        val result = apiReviewV1.getReviewsByRestaurantId(289)
        Log.d(tag, GsonBuilder().setPrettyPrinting().create().toJson(result))
    }
}