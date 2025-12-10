package com.sarang.torang.api.feed

import com.sarang.torang.data.remote.response.FavoriteFeedApiModel
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.LikeFeedApiModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiFeedV1 {
    @GET("page")
    suspend fun findByPage                  (@Header(value  = "authorization")   auth         : String?,
                                             @Query(value   = "page")            page         : Int,
                                             @Query(value   = "size")            size         : Int = 20) : List<FeedApiModel>
    @GET("user/reviewId/{reviewId}")
    suspend fun findByTokenAndId            (@Header(value  = "authorization")   auth         : String?,
                                             @Path(value    = "reviewId")        reviewId     : Int)      : List<FeedApiModel>
    @GET("id/{reviewId}")
    suspend fun findById                    (@Header(value  = "authorization")   auth         : String?,
                                             @Path(value    = "reviewId")        reviewId     : Int)      : FeedApiModel
    @GET("next")
    suspend fun findNextById                (@Header(value  = "authorization")   auth         : String?,
                                             @Query(value   = "reviewId")        reviewId     : Int,
                                             @Query(value   = "size")            size         : Int)      : List<FeedApiModel>
    @GET("restaurant/{restaurantId}")
    suspend fun findByRestaurantId          (@Header(value  = "authorization")   auth         : String?,
                                             @Path(value    = "restaurantId")    restaurantId : Int)     : List<FeedApiModel>
    @GET("user/{userId}/restaurant/{restaurantId}")
    suspend fun findByUserAndRestaurantId   (@Header(value  = "authorization")   auth         : String?,
                                             @Path(value    = "userId")          userId       : Int,
                                             @Path(value    = "restaurantId")    restaurantId : Int)     : List<FeedApiModel>
    @GET("user/{userId}")
    suspend fun findByUserId                (@Header(value  = "authorization")   auth         : String?,
                                             @Path(value    = "userId")          userId       : Int)      : List<FeedApiModel>
    @GET("v1/favorite")
    suspend fun findByFavorite              (@Header(value  = "authorization")   auth         : String)   : List<FavoriteFeedApiModel>
    @GET("v1/like")
    suspend fun findByLike                  (@Header(value  = "authorization")   auth         : String)   : List<LikeFeedApiModel>
}