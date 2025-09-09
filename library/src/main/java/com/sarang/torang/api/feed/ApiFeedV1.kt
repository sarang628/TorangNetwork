package com.sarang.torang.api.feed

import com.sarang.torang.data.remote.response.FeedApiModel
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiFeedV1 {
    @GET("findAll")                                     suspend fun findAll                     (@Header("authorization") auth: String?): List<FeedApiModel>
    @GET("page")                                        suspend fun page                        (@Header("authorization") auth: String?, @Query("page") page: Int, @Query("size") size : Int = 20)              : List<FeedApiModel>
    @GET("user/reviewId/{reviewId}")                    suspend fun userFeeds                   (@Header("authorization") auth: String?, @Path("reviewId") reviewId: Int)                                       : List<FeedApiModel>
    @GET("id/{reviewId}")                               suspend fun findById                    (@Header("authorization") auth: String?, @Path("reviewId") reviewId: Int)                                       : FeedApiModel
    @GET("next")                                        suspend fun findNextById                (@Header("authorization") auth: String?, @Query("reviewId") reviewId: Int, @Query("size") size: Int)            : List<FeedApiModel>
    @GET("restaurant/{restaurantId}")                   suspend fun findByRestaurantId          (@Header("authorization") auth: String?, @Path("restaurantId") restaurantId: Int)                               : List<FeedApiModel>
    @GET("user/{userId}/restaurant/{restaurantId}")     suspend fun findByUserAndRestaurantId   (@Header("authorization") auth: String?, @Path("userId") userId: Int, @Field("restaurantId") restaurantId: Int) : List<FeedApiModel>
    @GET("user/{userId}")                               suspend fun findByUserId                (@Header("authorization") auth: String?, @Path("userId") userId: Int)                                           : List<FeedApiModel>
}