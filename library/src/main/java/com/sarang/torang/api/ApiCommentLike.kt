package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CommentLikeApiModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiCommentLike {
                    @POST("getAllCommentLike")  suspend fun getAllCommentLike   (@Header("authorization") auth: String): List<CommentLikeApiModel>
    @FormUrlEncoded @POST("addCommentLike")     suspend fun addCommentLike      (@Header("authorization") auth: String, @Field("commentId") commentId: Int): CommentLikeApiModel
    @FormUrlEncoded @POST("deleteCommentLike")  suspend fun deleteCommentLike   (@Header("authorization") auth: String, @Field("commentId") commentId: Int): Boolean
}
