package com.rakapermanaptr.domain.haven.detail.di

import com.rakapermanaptr.domain.haven.detail.usecase.ObserveMessageUseCase
import org.koin.dsl.module

val chatUseCaseModules = module {
    factory { ObserveMessageUseCase(get()) }
}