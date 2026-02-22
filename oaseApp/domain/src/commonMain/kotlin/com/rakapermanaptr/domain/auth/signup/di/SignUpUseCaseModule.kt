package com.rakapermanaptr.domain.auth.signup.di

import com.rakapermanaptr.domain.auth.signup.usecase.PostSignUpUseCase
import org.koin.dsl.module

val signUpUseCaseModules = module {
    factory { PostSignUpUseCase(get()) }
}