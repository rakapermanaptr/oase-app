package com.rakapermanaptr.data.features.haven

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomMember(
    @SerialName("id")
    val id: String? = null,
    @SerialName("room_id")
    val roomId: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("joined_at")
    val joinedAt: String? = null
)