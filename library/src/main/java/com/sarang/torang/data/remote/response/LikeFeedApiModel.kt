package com.sarang.torang.data.remote.response

data class LikeFeedApiModel(
    val reviewId        : Int,
    val likeId          : Int,
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