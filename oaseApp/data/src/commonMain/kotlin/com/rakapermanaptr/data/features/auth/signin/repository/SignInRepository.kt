package com.rakapermanaptr.data.features.auth.signin.repository

import com.rakapermanaptr.domain.auth.signin.repository.ISignInRepository
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.builtin.Email

class SignInRepository(private val auth: Auth) : ISignInRepository {

    override suspend fun signIn(
        email: String,
        password: String
    ): Result<Unit> {
        return runCatching {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
        }
    }
}