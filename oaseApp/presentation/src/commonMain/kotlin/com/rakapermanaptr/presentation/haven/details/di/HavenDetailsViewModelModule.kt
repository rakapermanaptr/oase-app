package com.rakapermanaptr.presentation.haven.details.di

import com.rakapermanaptr.presentation.haven.details.HavenDetailsViewModel
import org.koin.dsl.module

val havenDetailsViewModelModule = module {
    factory { HavenDetailsViewModel(get()) }
}