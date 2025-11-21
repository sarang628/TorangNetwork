package com.sarang.torang.api

import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.MenuReviewApiModel
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

interface ApiReview {
                    @POST("updateReview")           suspend fun updateReview        (@Body reviewBody: FeedApiModel): Call<FeedApiModel>
                    @POST("deleteReview")           suspend fun deleteReview        (@Body review: FeedApiModel): FeedApiModel
                    @POST("addMenuReview")          suspend fun addMenuReview       (@Body menuReview: MenuReviewApiModel): Call<MenuReviewApiModel>
                    @POST("getMyMenuReviews")       suspend fun getMyMenuReviews    (@Body review: FeedApiModel): Call<ArrayList<MenuReviewApiModel>>
    @Multipart      @POST("updateReview")           suspend fun updateReview        (@PartMap params: HashMap<String, RequestBody>, @Part pictures: ArrayList<MultipartBody.Part>): FeedApiModel
    @Multipart      @POST("addReview")              suspend fun addReview           (@Part("review_id") review_id: Int? = null, @Part("contents") contents: RequestBody, @Part("rating") rating: Float, @Part("torang_id") torang_id: Int?, @Part("user_id") user_id: Int, @Part("uploadedImage") uploadedImage: List<Int>? = null, @Part file: ArrayList<MultipartBody.Part>? = null): FeedApiModel
    @FormUrlEncoded @POST("getReviews")             suspend fun getReviewsByRestaurantId (@Field("restaurant_id") restaurantId: Int): List<FeedApiModel>
    @FormUrlEncoded @POST("getMyReview")            suspend fun getMyReview         (@FieldMap params: Map<String, String>): FeedApiModel
    @FormUrlEncoded @POST("getMyReviews")           suspend fun getMyReviews        (@FieldMap params: Map<String, String>): ArrayList<FeedApiModel>
    @FormUrlEncoded @POST("getMyReviewsByUserId")   suspend fun getMyReviewsByUserId(@Field("userId") userId: Int): List<FeedApiModel>
    @FormUrlEncoded @POST("getReviewsById")         suspend fun getReviewsById      (@Field("reviewId") reviewId: Int): FeedApiModel
}