package com.rakapermanaptr.domain.di

import com.rakapermanaptr.domain.auth.signin.di.signInUseCaseModule
import com.rakapermanaptr.domain.auth.signup.di.signUpUseCaseModules
import com.rakapermanaptr.domain.haven.detail.di.chatUseCaseModules
import com.rakapermanaptr.domain.haven.di.havenUseCaseModule
import com.rakapermanaptr.domain.home.di.homeUseCaseModules
import org.koin.core.module.Module

val useCaseModules: List<Module>
    get() = listOf(
        homeUseCaseModules,
        signUpUseCaseModules,
        signInUseCaseModule,
        havenUseCaseModule,
        chatUseCaseModules
    )