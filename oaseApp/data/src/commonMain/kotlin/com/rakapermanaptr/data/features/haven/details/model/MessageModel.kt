package com.rakapermanaptr.data.features.haven.details.model

import com.rakapermanaptr.domain.haven.detail.entity.Message
import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    val id: String? = null,
    val room_id: String,
    val sender_id: String,
    val content: String,
    val created_at: String? = null
) {
    // Fungsi ini wajib ada agar bisa diubah ke Domain Model 'Message'
    fun toDomain() = Message(
        id = id.orEmpty(),
        roomId = room_id,
        senderId = sender_id,
        content = content,
        createdAt = created_at.orEmpty()
    )
}