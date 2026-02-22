package com.rakapermanaptr.domain.auth.signin.repository

interface ISignInRepository {
    suspend fun signIn(email: String, password: String): Result<Unit>
}