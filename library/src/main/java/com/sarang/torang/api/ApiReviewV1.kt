package com.sarang.torang.api

import com.sarang.torang.data.remote.response.FeedApiModel
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiReviewV1 {
    @GET("restaurant/{restaurantId}")
    suspend fun getReviewsByRestaurantId (
        @Path("restaurantId") restaurantId: Int): List<FeedApiModel>
}