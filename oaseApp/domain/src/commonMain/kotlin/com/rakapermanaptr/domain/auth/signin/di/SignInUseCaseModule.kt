package com.rakapermanaptr.domain.auth.signin.di

import com.rakapermanaptr.domain.auth.signin.usecase.PostSignInUseCase
import org.koin.dsl.module

val signInUseCaseModule = module {
    factory { PostSignInUseCase(get()) }
}