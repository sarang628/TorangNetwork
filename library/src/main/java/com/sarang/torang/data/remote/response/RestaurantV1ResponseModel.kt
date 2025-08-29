package com.sarang.torang.data.remote.response

data class RestaurantV1ResponseModel(
    val restaurantId    : Int?,
    val restaurantName  : String?,
    val address         : String?,
    val latitude        : Double?,
    val longitude       : Double?,
    val rating          : Float?,
    val tel             : String?,
    val prices          : String?,
    val restaurantType  : String?,
    val regionCode      : Int?,
    val reviewCount     : Int?,
    val website         : String?,
    val image           : String?,
    val restaurantTypeCd: String?,
)
