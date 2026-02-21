package com.rakapermanaptr.oase

import com.rakapermanaptr.data.di.appDataModules
import com.rakapermanaptr.data.di.supabaseModule
import com.rakapermanaptr.domain.di.useCaseModules
import com.rakapermanaptr.presentation.di.viewModelModules
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        supabaseModule,
        *appDataModules.toTypedArray(),
        *useCaseModules.toTypedArray(),
        *viewModelModules.toTypedArray()
    )
}