package com.sarang.torang.api

import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.FilterApiModel
import com.sarang.torang.data.remote.response.HoursOfOperationApiModel
import com.sarang.torang.data.remote.response.MenuApiModel
import com.sarang.torang.data.remote.response.PictureApiModel
import com.sarang.torang.data.remote.response.RestaurantDetailApiModel
import com.sarang.torang.data.remote.response.RestaurantResponseDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface ApiRestaurant {
    @POST("getAllRestaurant")
    suspend fun getAllRestaurant(): List<RestaurantResponseDto>

    @POST("getFilterRestaurant")
    suspend fun getFilterRestaurant(@Body filter: FilterApiModel): List<RestaurantResponseDto>

    @FormUrlEncoded
    @POST("getRestaurantById")
    suspend fun getRestaurantById(@Field("restaurant_id") restaurantId: Int): RestaurantResponseDto

    @FormUrlEncoded
    @POST("getRestaurantDetail")
    suspend fun getRestaurantDetail(@Field("restaurant_id") restaurantId: Int): RestaurantDetailApiModel

    @FormUrlEncoded
    @POST("getOpenHours")
    suspend fun getHoursOfOperation(@FieldMap params: Map<String, String>): List<HoursOfOperationApiModel>

    @FormUrlEncoded
    @POST("getMenus")
    suspend fun getMenus(@FieldMap params: Map<String, String>): List<MenuApiModel>

    @FormUrlEncoded
    @POST("getPictures")
    suspend fun getPictures(@FieldMap params: Map<String, String>): List<PictureApiModel>

    @Multipart
    @POST("fileUpload")
    suspend fun fileUpload(@PartMap params: HashMap<String, RequestBody>, @Part pictures: List<MultipartBody.Part>): FeedApiModel

    @FormUrlEncoded
    @POST("deletePicture")
    suspend fun deletePicture(@FieldMap params: Map<String, String>): Call<Void>

    @FormUrlEncoded
    @POST("saveMenu")
    suspend fun saveMenu(@FieldMap params: Map<String, String>): Call<Void>
}