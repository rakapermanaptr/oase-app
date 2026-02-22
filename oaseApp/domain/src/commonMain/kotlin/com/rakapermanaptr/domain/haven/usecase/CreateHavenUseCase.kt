package com.rakapermanaptr.domain.haven.usecase

import com.rakapermanaptr.domain.haven.repository.IHavenRepository

class CreateHavenUseCase(private val repository: IHavenRepository) {

    suspend operator fun invoke(userId: String) = repository.createHaven(userId)
}