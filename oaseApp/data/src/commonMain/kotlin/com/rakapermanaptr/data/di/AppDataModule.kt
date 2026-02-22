package com.rakapermanaptr.data.di

import com.rakapermanaptr.data.features.auth.signin.di.signInDataModule
import com.rakapermanaptr.data.features.auth.signup.di.signUpDataModule
import com.rakapermanaptr.data.features.haven.details.di.chatDataModule
import com.rakapermanaptr.data.features.haven.di.havenDataModule
import com.rakapermanaptr.data.features.home.di.homeDataModule
import org.koin.core.module.Module

val appDataModules: List<Module>
    get() = listOf(
        homeDataModule,
        signUpDataModule,
        signInDataModule,
        havenDataModule,
        chatDataModule
    )