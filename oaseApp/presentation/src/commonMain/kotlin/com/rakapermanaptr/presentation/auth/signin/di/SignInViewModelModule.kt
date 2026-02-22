package com.rakapermanaptr.presentation.auth.signin.di

import com.rakapermanaptr.presentation.auth.signin.SignInViewModel
import org.koin.dsl.module

val signInViewModelModule = module {
    factory { SignInViewModel(get()) }
}