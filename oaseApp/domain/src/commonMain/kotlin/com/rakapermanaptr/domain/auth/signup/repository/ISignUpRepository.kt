package com.rakapermanaptr.domain.auth.signup.repository

interface ISignUpRepository {
    suspend fun signUp(email: String, password: String): Result<Unit>
}