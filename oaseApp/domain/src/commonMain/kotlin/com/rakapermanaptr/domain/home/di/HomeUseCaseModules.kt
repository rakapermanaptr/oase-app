package com.rakapermanaptr.domain.home.di

import com.rakapermanaptr.domain.home.usecase.GetJournalsUseCase
import org.koin.dsl.module

val homeUseCaseModules = module {
    factory { GetJournalsUseCase(get()) }
}