package com.rakapermanaptr.presentation.di

import com.rakapermanaptr.presentation.auth.signin.di.signInViewModelModule
import com.rakapermanaptr.presentation.auth.signup.di.signUpViewModelModule
import com.rakapermanaptr.presentation.haven.details.di.havenDetailsViewModelModule
import com.rakapermanaptr.presentation.haven.di.havenViewModelModule
import com.rakapermanaptr.presentation.home.di.homeViewModelModule
import org.koin.core.module.Module

val viewModelModules: List<Module>
    get() = listOf(
        homeViewModelModule,
        signUpViewModelModule,
        signInViewModelModule,
        havenViewModelModule,
        havenDetailsViewModelModule
    )