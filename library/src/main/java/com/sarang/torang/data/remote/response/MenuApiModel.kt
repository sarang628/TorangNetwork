package com.sarang.torang.data.remote.response

/**
 *
 */
data class MenuApiModel (
    val restaurantId: Int = 0,
    val rating: Float = 0f,
    val menuId: Int? = null,
    val parentId: Int? = null,
    val menuName: String? = null,
    val menuPrice: Int? = null,
    val menuPicUrl: String? = null,
    val order: Int? = null,
    val children: List<MenuApiModel>? = null,
)