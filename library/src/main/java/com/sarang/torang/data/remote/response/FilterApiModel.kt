package com.sarang.torang.data.remote.response


data class FilterApiModel(
    val searchType      : String        = "AROUND",
    val keyword         : String?       = null,
    val distances       : String?       = null,
    val prices          : List<String>? = null,
    val restaurantTypes : List<String>? = null,
    val ratings         : List<String>? = null,
    val latitude        : Double?       = null,
    val longitude       : Double?       = null,
    val northEastLat    : Double?       = null,
    val northEastLon    : Double?       = null,
    val southWestLat    : Double?       = null,
    val southWestLon    : Double?       = null
)