package com.rakapermanaptr.data.features.haven.details.di

import com.rakapermanaptr.data.features.haven.details.repository.ChatRepository
import com.rakapermanaptr.domain.haven.detail.repository.IChatRepository
import org.koin.dsl.module

val chatDataModule = module {
    single<IChatRepository> { ChatRepository(get()) }
}