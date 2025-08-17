package com.sarang.torang.data.remote.response

data class HoursOfOperationApiModel(
    val restaurant_id: Int,
    val start_time: String,
    val end_time: String,
    val day: String
)
