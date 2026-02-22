package com.rakapermanaptr.data.di

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import org.koin.dsl.module

val supabaseModule = module {
    single<SupabaseClient> {
        createSupabaseClient(
            supabaseUrl = "https://vnbxokumeauolscemdel.supabase.co",
            supabaseKey = "sb_publishable_KCwDoF01Hmfut5yVJhsrRA_NizdD9IW"
        ) {
            install(Postgrest)
            install(Auth) {
                alwaysAutoRefresh = true
            }
            install(Storage)
        }
    }

    single<Postgrest> { get<SupabaseClient>().postgrest }
    single<Auth> { get<SupabaseClient>().auth }
    single<Storage> { get<SupabaseClient>().storage }
}

