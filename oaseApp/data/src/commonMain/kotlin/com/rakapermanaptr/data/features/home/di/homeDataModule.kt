package com.rakapermanaptr.data.features.home.di

import com.rakapermanaptr.data.features.home.repository.HomeRepository
import com.rakapermanaptr.domain.home.repository.IHomeRepository
import org.koin.dsl.module

val homeDataModule = module {
    single<IHomeRepository> { HomeRepository(get()) }
}