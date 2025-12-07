package com.sarang.torang.data.remote.response

data class FavoriteFeedApiModel(
    val reviewId        : Int,
    val favoriteId      : Int,
    val picture         : Picture,
    val createDate      : String
){
    data class Picture(
        val pictureId : Int,
        val pictureUrl  : String,
        val width       : Int,
        val height      : Int
    )
}