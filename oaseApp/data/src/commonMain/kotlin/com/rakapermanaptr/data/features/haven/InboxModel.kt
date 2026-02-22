package com.rakapermanaptr.data.features.haven

import com.rakapermanaptr.domain.haven.entity.Haven
import kotlinx.serialization.Serializable

@Serializable
data class InboxModel(
    val my_id: String,
    val room_id: String,
    val is_group: Boolean = false,
    val opponent_name: String? = null,
    val opponent_avatar: String? = null,
    val opponent_email: String? = null,
    val last_message: String? = null,
    val last_message_time: String? = null
)

fun InboxModel.toDomain() = Haven(
    myId = my_id,
    roomId = room_id,
    lastMessage = last_message.orEmpty(),
    opponentName = opponent_name.orEmpty(),
    lastMessageTime = last_message_time.orEmpty()
)