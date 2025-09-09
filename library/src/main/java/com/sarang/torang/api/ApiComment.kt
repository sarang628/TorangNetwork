package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CommentListApiModel
import com.sarang.torang.data.remote.response.RemoteComment
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * http://sarang628.iptime.org:8081/swagger-ui/#/%EC%BD%94%EB%A9%98%ED%8A%B8
 */
interface ApiComment {
                    @POST("modifyComment")              suspend fun modifyComment           (@Body comment: RemoteComment): RemoteComment
    @FormUrlEncoded @POST("addComment")                 suspend fun addComment              (@Header("authorization") auth: String, @Field("review_id") review_id: Int, @Field("comment") comment: String, @Field("parentCommentId") parentCommentId: Int? = null, @Field("tagUserId") tagUserId: Int? = null, ): RemoteComment
    @FormUrlEncoded @POST("deleteComment")              suspend fun deleteComment           (@Field("commentId") commentId: Int): Boolean
    @FormUrlEncoded @POST("getComments")                suspend fun getComments             (@Header("authorization") auth: String, @Field("review_id") reviewId: Int): CommentListApiModel
    @FormUrlEncoded @POST("getCommentsWithOneReply")    suspend fun getCommentsWithOneReply (@Header("authorization") auth: String, @Field("review_id") reviewId: Int): CommentListApiModel
    @FormUrlEncoded @POST("getSubComments")             suspend fun getSubComments          (@Header("authorization") auth: String, @Field("parentCommentId") parentCommentId: Int): List<RemoteComment>
}