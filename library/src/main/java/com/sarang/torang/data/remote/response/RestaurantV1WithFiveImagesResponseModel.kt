package com.sarang.torang.data.remote.response

data class RestaurantV1WithFiveImagesResponseModel(
    val restaurant: RestaurantV1ResponseModel?,
    val images: List<String>?
)
