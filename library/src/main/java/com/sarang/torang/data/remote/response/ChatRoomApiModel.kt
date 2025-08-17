package com.sarang.torang.data.remote.response

data class ChatRoomApiModel(
    val roomId: Int,
    val createDate: String,
    val users: List<ChatUserApiModel>,
)

/*
fun ChatRoomApiModel.toChatRoomEntity(): ChatRoomEntity = ChatRoomEntity(
    roomId = roomId,
    createDate = createDate,
)*/
