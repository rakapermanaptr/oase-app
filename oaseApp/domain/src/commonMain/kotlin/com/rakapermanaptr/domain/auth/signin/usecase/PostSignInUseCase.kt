package com.rakapermanaptr.domain.auth.signin.usecase

import com.rakapermanaptr.domain.auth.signin.repository.ISignInRepository

class PostSignInUseCase(private val repository: ISignInRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.signIn(email, password)
}