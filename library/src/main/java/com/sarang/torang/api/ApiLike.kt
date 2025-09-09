package com.sarang.torang.api

import com.sarang.torang.data.remote.response.FollowerApiModel
import com.sarang.torang.data.remote.response.LikeApiModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiLike {
    @FormUrlEncoded @POST("getLikeUserByReviewId")      suspend fun getLikeUserByReviewId       (@Header("authorization") auth: String, @Field("reviewId") reviewId: String): List<FollowerApiModel>
    @FormUrlEncoded @POST("addLike")                    suspend fun addLike                     (@Header("authorization") auth: String, @Field("reviewId") reviewId: Int): LikeApiModel
    @FormUrlEncoded @POST("deleteLike")                 suspend fun deleteLike                  (@Field("likeId") likeId: Int): LikeApiModel
}
