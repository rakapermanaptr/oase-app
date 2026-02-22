package com.rakapermanaptr.domain.auth.signup.usecase

import com.rakapermanaptr.domain.auth.signup.repository.ISignUpRepository

class PostSignUpUseCase(private val repository: ISignUpRepository) {

    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        if (!email.contains("@")) {
            return Result.failure(Exception("Format email salah"))
        }

        return repository.signUp(email, password)
    }
}