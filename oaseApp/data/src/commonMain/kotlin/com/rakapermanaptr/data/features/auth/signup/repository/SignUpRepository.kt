package com.rakapermanaptr.data.features.auth.signup.repository

import com.rakapermanaptr.domain.auth.signup.repository.ISignUpRepository
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class SignUpRepository(private val auth: Auth): ISignUpRepository {
    override suspend fun signUp(
        email: String,
        password: String,
        displayName: String
    ): Result<Unit> {
        return runCatching {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
                data = buildJsonObject {
                    put("display_name", displayName)
                }
            }
        }
    }
}