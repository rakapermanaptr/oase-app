package com.rakapermanaptr.data.di

import com.rakapermanaptr.data.features.home.di.homeDataModule
import org.koin.core.module.Module

val appDataModules: List<Module>
    get() = listOf(
        homeDataModule
    )