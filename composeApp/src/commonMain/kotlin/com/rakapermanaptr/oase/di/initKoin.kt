package com.rakapermanaptr.oase.di

import com.rakapermanaptr.data.di.appDataModules
import com.rakapermanaptr.data.di.supabaseModule
import com.rakapermanaptr.domain.di.useCaseModules
import com.rakapermanaptr.presentation.di.viewModelModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        supabaseModule,
        *appDataModules.toTypedArray(),
        *useCaseModules.toTypedArray(),
        *viewModelModules.toTypedArray()
    )
}