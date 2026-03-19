package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiFeed
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
class ApiCommentTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiComment: ApiComment
    @Inject lateinit var apiFeed: ApiFeed
    @Inject lateinit var login: ApiLogin

    private var auth = ""
    private var userId = -1

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        val result = login.emailLogin("sry_ang@naver.com", Encrypt.encrypt("Torang!234"))
        auth = result.token
        userId = result.profile.userId
    }

    @Test
    fun findByReviewId() = runTest {
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val result = apiComment.findByReviewId(auth, feeds[0].reviewId)
        prettyPrint(result);
    }

    @Test
    fun addCommentTest() = runTest {
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val result = apiComment.addComment(auth = auth,
            reviewId = feeds.get(0).reviewId,
            comment = "comment test",
            parentCommentId = null,
            tagUserId = null)
        prettyPrint(result)
    }

    @Test
    fun deleteTest() = runTest {
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val comments = apiComment.findByReviewId(auth, feeds[0].reviewId)
        comments.list.firstOrNull { it.user.userId == userId }?.let {
            val result = apiComment.deleteComment(it.comment_id)
            print(result)
        } ?: throw Exception("등록된 커멘트가 없음")
    }

    @Test
    fun addReplyTest() = runTest {
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val comment = apiComment.addComment(auth = auth,
            reviewId = feeds.get(0).reviewId,
            comment = "addReplyTest",
            parentCommentId = null,
            tagUserId = null)

        val reply = apiComment.addComment(auth = auth,
            reviewId = feeds.get(0).reviewId,
            comment = "addReplyTest",
            parentCommentId = comment.comment_id,
            tagUserId = null
        )

        prettyPrint(reply)
    }

    @Test
    fun getCommentsWithOneReply() = runTest{
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val result = apiComment.getCommentsWithOneReply(auth = auth, reviewId = feeds[0].reviewId)
        prettyPrint(result)
    }

    @Test
    fun nextCommentsTest() = runTest {
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val result = apiComment.nextComments(auth, feeds[0].reviewId)
        prettyPrint(result)
    }

    @Test
    fun updateTest() = runTest {
        val feeds = apiFeed.getFeedsWithPage(auth = auth, 0)
        val result = apiComment.findByReviewId(auth, feeds[0].reviewId)
        val update = apiComment.updateComment(commentId = result.list[0].comment_id,
                                              comment = result.list[0].copy(comment = "update"))

        prettyPrint(update)
    }
}