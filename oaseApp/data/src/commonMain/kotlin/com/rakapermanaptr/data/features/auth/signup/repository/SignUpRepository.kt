package com.rakapermanaptr.data.features.auth.signup.repository

import com.rakapermanaptr.domain.auth.signup.repository.ISignUpRepository
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.builtin.Email

class SignUpRepository(private val auth: Auth): ISignUpRepository {
    override suspend fun signUp(
        email: String,
        password: String
    ): Result<Unit> {
        return runCatching {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
        }
    }
}