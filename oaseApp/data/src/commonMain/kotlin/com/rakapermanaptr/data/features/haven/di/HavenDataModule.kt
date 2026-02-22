package com.rakapermanaptr.data.features.haven.di

import com.rakapermanaptr.data.features.haven.repository.HavenRepository
import com.rakapermanaptr.domain.haven.repository.IHavenRepository
import org.koin.dsl.module

val havenDataModule = module {
    single<IHavenRepository> { HavenRepository(get()) }
}