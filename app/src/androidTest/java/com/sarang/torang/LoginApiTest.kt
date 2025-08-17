package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.handle
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
class LoginApiTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiLogin: ApiLogin

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun loginTest() = runTest {
        apiLogin.emailLogin("sarang628@naver.com", Encrypt.encrypt("aaaaa"))
    }

    @Test
    fun loginFailedTest() = runTest {
        try {
            apiLogin.emailLogin("sarang628@naver.com", Encrypt.encrypt("aaaaaa"))
        } catch (e: retrofit2.HttpException) {
            Assert.assertEquals(500, e.code())
            Assert.assertEquals("로그인에 실패하였습니다.", e.handle())
        }
    }
}