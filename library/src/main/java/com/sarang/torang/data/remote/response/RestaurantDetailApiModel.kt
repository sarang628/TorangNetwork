package com.sarang.torang.data.remote.response

import com.google.gson.Gson

data class RestaurantDetailApiModel(
    val restaurant: RestaurantResponseDto,
    val pictures: ArrayList<PictureApiModel>,
    val comments: ArrayList<RestaurantCommentApiModel>,
    val menus: ArrayList<MenuApiModel>,
    val hoursOfOperations: List<HoursOfOperationApiModel>,
    val restaurantRating: RestaurantRatingApiModel
) {
    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }
}