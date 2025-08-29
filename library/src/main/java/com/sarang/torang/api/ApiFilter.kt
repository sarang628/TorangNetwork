package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CityApiModel
import com.sarang.torang.data.remote.response.FilterApiModel
import com.sarang.torang.data.remote.response.FilterResponseModel
import com.sarang.torang.data.remote.response.NationApiModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiFilter {
    @GET("getCities")                 suspend fun getCities(): List<CityApiModel>
    @GET("getCitiesByNationId")       suspend fun getCitiesByNationId(@Query("nationId") nationId: Int): List<CityApiModel>
    @GET("getNations")                suspend fun getNations(): List<NationApiModel>
    @POST("filter/searchType/AROUND") suspend fun aroundRestaurant(@Body filterApiModel: FilterApiModel): FilterResponseModel
    @POST("filter/searchType/BOUND")  suspend fun boundRestaurant(@Body filterApiModel: FilterApiModel): FilterResponseModel
}