package com.rakapermanaptr.data.features.auth.signin.di

import com.rakapermanaptr.data.features.auth.signin.repository.SignInRepository
import com.rakapermanaptr.domain.auth.signin.repository.ISignInRepository
import org.koin.dsl.module

val signInDataModule = module {
    single<ISignInRepository> { SignInRepository(get()) }
}