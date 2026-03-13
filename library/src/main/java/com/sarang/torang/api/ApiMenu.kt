package com.sarang.torang.api

import com.sarang.torang.data.remote.response.MenuApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMenu {
    @GET("v1/{restaurantId}") suspend fun findByRestaurantId (@Path("restaurantId") restaurantId : Int): List<MenuApiModel>
}