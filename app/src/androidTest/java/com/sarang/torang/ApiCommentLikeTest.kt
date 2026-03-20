package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiCommentLike
import com.sarang.torang.api.ApiLogin
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
class ApiCommentLikeTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiCommentLike: ApiCommentLike
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
        val result = apiCommentLike.findAll(auth)
        prettyPrint(result)
    }

    @Test
    fun addCommentLikeTest() = runTest {
        val result = apiCommentLike.addCommentLike(auth, 1)
        prettyPrint(result)
    }

    @Test
    fun deleteCommentLikeTest() = runTest {
        val result = apiCommentLike.deleteCommentLike(auth, 1)
        prettyPrint(result)
    }
}