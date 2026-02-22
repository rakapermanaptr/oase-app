package com.rakapermanaptr.domain.haven.detail.usecase

import com.rakapermanaptr.domain.haven.detail.repository.IChatRepository

class ObserveMessageUseCase(private val repository: IChatRepository) {

    suspend operator fun invoke(roomId: String) = repository.observeMessages(roomId)
}