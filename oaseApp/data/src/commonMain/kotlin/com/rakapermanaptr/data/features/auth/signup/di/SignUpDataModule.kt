package com.rakapermanaptr.data.features.auth.signup.di

import com.rakapermanaptr.data.features.auth.signup.repository.SignUpRepository
import com.rakapermanaptr.domain.auth.signup.repository.ISignUpRepository
import org.koin.dsl.module

val signUpDataModule = module {
    single<ISignUpRepository> { SignUpRepository(get()) }
}