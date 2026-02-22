package com.rakapermanaptr.domain.haven.detail.repository

import com.rakapermanaptr.domain.haven.detail.entity.Message
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    suspend fun observeMessages(roomId: String): Flow<List<Message>>
//    suspend fun sendMessage(roomId: String, content: String): Result<Unit>
}