package com.rakapermanaptr.domain.haven.di

import com.rakapermanaptr.domain.haven.usecase.CreateHavenUseCase
import com.rakapermanaptr.domain.haven.usecase.GetHavenListUseCase
import org.koin.dsl.module

val havenUseCaseModule = module {
    factory { CreateHavenUseCase(get()) }
    factory { GetHavenListUseCase(get()) }
}