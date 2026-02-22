package com.rakapermanaptr.presentation.auth.signup.di

import com.rakapermanaptr.presentation.auth.signup.SignUpViewModel
import org.koin.dsl.module

val signUpViewModelModule = module {
    factory { SignUpViewModel(get()) }
}