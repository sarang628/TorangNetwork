package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserApiModel(
    @SerializedName("user_id")          val userId          : Int,
    @SerializedName("user_name")        val userName        : String,
    @SerializedName("email")            val email           : String?,
    @SerializedName("login_platform")   val loginPlatform   : String?,
    @SerializedName("create_date")      val createDate      : String?,
    @SerializedName("profile_pic_url")  val profilePicUrl   : String,
    @SerializedName("post")             val post            : Int,
    @SerializedName("follower")         val follower        : Int,
    @SerializedName("following")        val following       : Int,
    @SerializedName("follow")           val follow          : Int
)
