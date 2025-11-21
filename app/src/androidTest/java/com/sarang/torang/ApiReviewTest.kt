package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiChat
import com.sarang.torang.api.ApiLogin
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
    @Inject lateinit var apiChat: ApiChat
    @Inject lateinit var sessionService: SessionService
    @Inject lateinit var login: ApiLogin

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        val result = login.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234"))
        sessionService.saveToken(result.token);
    }

    @Test
    fun getChatRoomTest() = runTest {
        val result = apiChat.getChatRoom(sessionService.getToken()!!)
        Assert.assertEquals(result.isNotEmpty(), true)
        Assert.assertEquals(result[0].users[0].userName.isNotEmpty(), true)
    }
}