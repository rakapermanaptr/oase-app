package com.rakapermanaptr.data.features.haven

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomModel(
    @SerialName("id")
    val id: String? = null, // UUID dari Supabase
    @SerialName("name")
    val name: String? = null,
    @SerialName("is_group")
    val isGroup: Boolean = false,
    @SerialName("created_at")
    val createdAt: String? = null
)