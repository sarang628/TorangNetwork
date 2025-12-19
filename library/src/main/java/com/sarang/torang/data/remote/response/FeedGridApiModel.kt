package com.sarang.torang.data.remote.response

data class FeedGridApiModel(
    val reviewId        : Int,
    val picture         : Picture
){
    data class Picture(
        val pictureId : Int,
        val pictureUrl  : String,
        val width       : Int,
        val height      : Int
    )
}