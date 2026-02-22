package com.rakapermanaptr.presentation.haven.di

import com.rakapermanaptr.presentation.haven.HavenViewModel
import org.koin.dsl.module

val havenViewModelModule = module {
    factory { HavenViewModel(get(), get()) }
}