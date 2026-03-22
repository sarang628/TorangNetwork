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
    /**
     * 도시 불러오기
     */
    @GET("getCities")
    suspend fun getCities(): List<CityApiModel>

    /**
     * 국가 ID로 도시 불러오기
     */
    @GET("getCitiesByNationId")
    suspend fun getCitiesByNationId(@Query("nationId") nationId: Int): List<CityApiModel>

    /**
     * 도시 불러오기
     */
    @GET("getNations")
    suspend fun getNations(): List<NationApiModel>

    /**
     * 주변 음식점 검색
     */
    @POST("searchType/AROUND")
    suspend fun aroundRestaurant(@Body filterApiModel: FilterApiModel): FilterResponseModel

    /**
     * 지도 범위 음식점 검색
     */
    @POST("searchType/BOUND")
    suspend fun boundRestaurant(@Body filterApiModel: FilterApiModel): FilterResponseModel
}