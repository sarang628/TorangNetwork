package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CommentListApiModel
import com.sarang.torang.data.remote.response.RemoteComment
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * http://sarang628.iptime.org:8081/swagger-ui/#/%EC%BD%94%EB%A9%98%ED%8A%B8
 */
interface ApiComment {
    /**
     * 커멘트 불러오기
     */
    @GET("review/{reviewId}")
    suspend fun findByReviewId(
        @Header("authorization") auth: String,
        @Path("reviewId") reviewId: Int
    ): CommentListApiModel

    /**
     * 커멘트와 댓글1개 불러오기
     */
    @GET("getCommentsWithOneReply/{reviewId}")
    suspend fun getCommentsWithOneReply(
        @Header("authorization") auth: String,
        @Path("reviewId") reviewId: Int
    ): CommentListApiModel

    /**
     * 다음 커멘트 불러오기
     */
    @GET("nextComments/{commentId}")
    suspend fun nextComments(
        @Header("authorization") auth: String,
        @Path("commentId") commentId: Int
    ): List<RemoteComment>

    /**
     * 커멘트 추가하기
     */
    @FormUrlEncoded
    @POST("review/{reviewId}")
    suspend fun addComment(
        @Header("authorization") auth: String,
        @Path("reviewId") reviewId: Int,
        @Field("comment") comment: String,
        @Field("parentCommentId") parentCommentId: Int? = null,
        @Field("tagUserId") tagUserId: Int? = null
    ): RemoteComment

    /**
     * 커멘트 업데이트
     */
    @PUT("{commentId}")
    suspend fun updateComment(
        @Path("commentId") commentId: Int,
        @Body comment: RemoteComment
    ): RemoteComment

    @DELETE("{commentId}")
    suspend fun deleteComment(@Path("commentId") commentId: Int): Boolean
}