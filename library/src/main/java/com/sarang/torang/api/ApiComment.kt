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
    @GET("review/{reviewId}")
    suspend fun findByReviewId          (@Header("authorization")       auth    : String,
                                         @Path  ("reviewId")            reviewId: Int): CommentListApiModel

    @GET("getCommentsWithOneReply/{reviewId}")
    suspend fun getCommentsWithOneReply (@Header("authorization")       auth    : String,
                                         @Path  ("reviewId")            reviewId: Int): CommentListApiModel

    @GET("nextComments/{commentId}")
    suspend fun nextComments            (@Header("authorization")       auth    : String,
                                         @Path  ("commentId")           commentId: Int): List<RemoteComment>

    @FormUrlEncoded
    @POST("review/{reviewId}")
    suspend fun addComment              (@Header("authorization")       auth        : String,
                                         @Path  ("reviewId")            reviewId    : Int,
                                         @Field ("comment")             comment     : String,
                                         @Field ("parentCommentId")     parentCommentId: Int? = null,
                                         @Field ("tagUserId")           tagUserId   : Int? = null): RemoteComment
    @PUT("{commentId}")
    suspend fun updateComment           (@Path  ("commentId")           commentId   : Int,
                                         @Body                                  comment     : RemoteComment): RemoteComment
    @DELETE("{commentId}")
    suspend fun deleteComment           (@Path  ("commentId")           commentId   : Int): Boolean
}