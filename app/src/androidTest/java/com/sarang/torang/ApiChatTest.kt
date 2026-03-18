package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiChat
import com.sarang.torang.api.ApiLogin
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.UUID
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ApiChatTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiChat: ApiChat
    @Inject lateinit var login: ApiLogin

    private var auth = ""

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        val result = login.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234"))
        auth = result.token
    }

    @Test
    fun findAllTest() = runTest {
        val result = apiChat.findAll(auth)
        prettyPrint(result);
        Assert.assertEquals(result.isNotEmpty(), true)
        Assert.assertEquals(result[0].users[0].userName.isNotEmpty(), true)
    }

    @Test
    fun getContentTest() = runTest {
        val chatRooms = apiChat.findAll(auth)
        val result = apiChat.getContents(auth, chatRooms[0].roomId)
        prettyPrint(result)
    }

    @Test
    fun createChatRoomTest() = runTest {
        val result = apiChat.createChatRoom(auth, 0)
        prettyPrint(result)
    }

    @Test
    fun addChatTest() = runTest {
        val result = apiChat.findAll(auth)
        val result1 = apiChat.addChat(auth = auth,
                                      roomId = result.get(0).roomId,
                                      message = "test")
        prettyPrint(result1)
    }
}