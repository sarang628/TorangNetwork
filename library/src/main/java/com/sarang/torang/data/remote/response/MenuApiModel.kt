package com.sarang.torang.data.remote.response

/**
 *
 */
data class MenuApiModel (
    val restaurant_id: Int = 0,
    val rating: Float = 0f,
    val menu_id: String? = null,
    val menu_name: String? = null,
    val menu_price: String? = null,
    val menu_pic_url: String? = null,
)