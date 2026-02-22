package com.rakapermanaptr.domain.haven.detail.entity

data class Message(
    val id: String? = null,
    val roomId: String,
    val senderId: String,
    val content: String,
    val createdAt: String? = null
)