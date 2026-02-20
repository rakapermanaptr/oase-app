package com.rakapermanaptr.domain.di

import com.rakapermanaptr.domain.home.di.homeUseCaseModules
import org.koin.core.module.Module

val useCaseModules: List<Module>
    get() = listOf(
        homeUseCaseModules
    )