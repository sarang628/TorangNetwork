package com.sarang.torang.data.remote.response

data class FavoriteFeedApiModel(
    val reviewId: Int,
    val favoriteId: Int,
    val picture : Picture
){
    data class Picture(
        val pictureUrl : String,
        val width : Int,
        val height : Int
    )
}