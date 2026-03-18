package com.sarang.torang.api

import com.sarang.torang.data.remote.response.ChatApiModel
import com.sarang.torang.data.remote.response.ChatRoomApiModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiChat {
@GET("rooms")
suspend fun findAll (@Header("authorization") auth: String): List<ChatRoomApiModel>
@GET("rooms/{roomId}/chats")
suspend fun getContents     (@Header("authorization") auth: String,
                             @Path("roomId") roomId: Int): List<ChatApiModel>
@FormUrlEncoded
@POST("rooms")
suspend fun createChatRoom  (@Header("authorization") auth: String,
                             @Field("userId") userId: Int): ChatRoomApiModel
@FormUrlEncoded
@POST("rooms/{roomId}/chats")
suspend fun addChat (@Header("authorization") auth: String,
                     @Path("roomId") roomId: Int,
                     @Field("message") message: String): ChatApiModel
}