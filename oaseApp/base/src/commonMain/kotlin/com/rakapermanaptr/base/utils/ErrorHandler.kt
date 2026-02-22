package com.rakapermanaptr.base.utils

import io.github.jan.supabase.auth.exception.AuthRestException

fun handleSupabaseError(error: Throwable): String {
    return when (error) {
        is AuthRestException -> {
            // Supabase mengembalikan kode string seperti "invalid_credentials"
            when (error.error) {
                "invalid_credentials" -> "Email atau password salah. Silakan coba lagi."
                "user_not_found" -> "Pengguna tidak ditemukan."
                "email_not_confirmed" -> "Silakan konfirmasi email Anda terlebih dahulu."
                else -> "Terjadi kesalahan autentikasi: ${error.error}"
            }
        }
        else -> error.message ?: "Terjadi kesalahan yang tidak diketahui"
    }
}