package com.sarang.torang.api

import com.sarang.torang.data.remote.response.FavoriteFeedApiModel
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.FeedGridApiModel
import com.sarang.torang.data.remote.response.LikeFeedApiModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiFeedV1 {
    /**
     * 피드 페이지로 불러오기
     */
    @GET("page/{page}/size/{size}")
    suspend fun findByPage(
        @Header(value = "authorization") auth: String?,
        @Path(value = "page") page: Int,
        @Path(value = "size") size: Int = 20
    ): List<FeedApiModel>

    /**
     * 피드 리뷰Id로 불러오기
     */
    @GET("user/reviewId/{reviewId}")
    suspend fun findUsersReviewsByReviewId(
        @Header(value = "authorization") auth: String?,
        @Path(value = "reviewId") reviewId: Int
    ): List<FeedApiModel>

    /**
     * 피드 리뷰Id로 불러오기
     */
    @GET("id/{reviewId}")
    suspend fun findById(
        @Header(value = "authorization") auth: String?,
        @Path(value = "reviewId") reviewId: Int
    ): FeedApiModel

    /**
     * 다음 피드 불러오기
     */
    @GET("next/reviewId/{reviewId}/size/{size}")
    suspend fun findNextById(
        @Header(value = "authorization") auth: String?,
        @Path(value = "reviewId") reviewId: Int,
        @Path(value = "size") size: Int
    ): List<FeedApiModel>

    /**
     * 음식점 ID로 피드 불러오기
     */
    @GET("restaurant/{restaurantId}")
    suspend fun findByRestaurantId(
        @Header(value = "authorization") auth: String?,
        @Path(value = "restaurantId") restaurantId: Int
    ): List<FeedApiModel>

    /**
     * 특정 유저가 음식점에 올린 리뷰 불러오기
     */
    @GET("user/{userId}/restaurant/{restaurantId}")
    suspend fun findByUserAndRestaurantId(
        @Header(value = "authorization") auth: String?,
        @Path(value = "userId") userId: Int,
        @Path(value = "restaurantId") restaurantId: Int
    ): List<FeedApiModel>

    /**
     * 특정 유저의 피드 불러오기
     */
    @GET("user/{userId}")
    suspend fun findByUserId(
        @Header(value = "authorization") auth: String?,
        @Path(value = "userId") userId: Int
    ): List<FeedApiModel>

    /**
     * 내가 즐겨찾기한 피드 불러오기
     */
    @GET("favorite")
    suspend fun findByFavorite(@Header(value = "authorization") auth: String): List<FavoriteFeedApiModel>

    /**
     * 내가 좋아요한 피드 불러오기
     */
    @GET("like")
    suspend fun findByLike(@Header(value = "authorization") auth: String): List<LikeFeedApiModel>

    /**
     * 피드 그리드 불러오기
     */
    @GET("feedGrid/{reviewId}/offset/{offset}")
    suspend fun findByFeedGrid(
        @Path(value = "reviewId") reviewId: Int,
        @Path(value = "offset") offset: Int
    ): List<FeedGridApiModel>
}