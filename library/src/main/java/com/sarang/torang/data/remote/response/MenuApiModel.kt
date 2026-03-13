package com.sarang.torang.data.remote.response

/**
 *
 */
data class MenuApiModel (
    val restaurantId: Int = 0,
    val rating: Float = 0f,
    val menuId: String? = null,
    val menuName: String? = null,
    val menuPrice: String? = null,
    val menuPicUrl: String? = null,
    val order: Int? = null,
    val children: List<MenuApiModel>? = null,
)