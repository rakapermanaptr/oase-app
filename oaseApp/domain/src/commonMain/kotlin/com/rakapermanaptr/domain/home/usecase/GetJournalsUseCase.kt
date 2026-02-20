package com.rakapermanaptr.domain.home.usecase

import com.rakapermanaptr.domain.home.repository.IHomeRepository

class GetJournalsUseCase(private val repository: IHomeRepository) {

    suspend operator fun invoke() = repository.getJournals()
}