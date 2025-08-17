package com.sarang.torang.data.remote.response

/**
 *
 */
data class PictureApiModel (
    val picture_id: Int = 0,
    val restaurant_id: Int = 0,
    val user_id: Int = 0,
    val review_id: Int = 0,
    val picture_url: String? = null,
    val create_date: String? = null,
    val menu_id: Int = 0,
    val menu: MenuApiModel? = null,
    val width: Int = 0,
    val height: Int = 0
)