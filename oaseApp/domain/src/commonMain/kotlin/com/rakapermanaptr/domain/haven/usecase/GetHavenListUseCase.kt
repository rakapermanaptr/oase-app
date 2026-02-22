package com.rakapermanaptr.domain.haven.usecase

import com.rakapermanaptr.domain.haven.repository.IHavenRepository

class GetHavenListUseCase(private val repository: IHavenRepository) {

    suspend operator fun invoke() = repository.getHavenList()
}