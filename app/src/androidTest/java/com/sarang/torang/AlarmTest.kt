package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.handle
import com.sarang.torang.data.remote.response.AlarmApiModel
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
class AlarmTest {

    val tag = "__AlarmTest"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiAlarm: ApiAlarm

    @Inject
    lateinit var apiLogin: ApiLogin

    var token = ""

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        token = apiLogin.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234")).token
    }

    @Test
    fun getAlarmTest() = runTest {
        val result : List<AlarmApiModel>? = apiAlarm.findAll(token).body()
        println(GsonBuilder().setPrettyPrinting().create().toJson(result))
        //Log.d(tag, GsonBuilder().setPrettyPrinting().create().toJson(result))
    }

    @Test
    fun getAlarmFailedTest() = runTest {
        try {
            apiAlarm.findAll("auth")
        } catch (e: retrofit2.HttpException) {
            Assert.assertEquals(500, e.code())
            Assert.assertEquals("인증에 실패하였습니다.", e.handle())
        }
    }

    @Test
    fun deleteAlarmTest() = runTest {
        apiAlarm.delete(token,123)
    }
}