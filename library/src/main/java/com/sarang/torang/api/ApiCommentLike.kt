package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CommentLikeApiModel
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiCommentLike {
    /**
     * 내가 좋아요한 커멘트
     */
    @GET("/api/commentLike")
    suspend fun findAll(@Header("authorization") auth: String): List<CommentLikeApiModel>

    /**
     * 커멘트 좋아요 하기
     */
    @FormUrlEncoded
    @POST("/api/commentLike")
    suspend fun addCommentLike(
        @Header("authorization") auth: String,
        @Field("commentId") commentId: Int
    ): CommentLikeApiModel

    @DELETE("{commentId}")
    suspend fun deleteCommentLike(
        @Header("authorization") auth: String,
        @Path("commentId") commentId: Int
    ): Boolean
}
