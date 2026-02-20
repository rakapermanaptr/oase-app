package com.rakapermanaptr.data.features.home.repository

import com.rakapermanaptr.data.features.home.model.JournalDto
import com.rakapermanaptr.data.features.home.model.toDomain
import com.rakapermanaptr.domain.home.entity.Journal
import com.rakapermanaptr.domain.home.repository.IHomeRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class HomeRepository(private val postgrest: Postgrest): IHomeRepository {

    override suspend fun getJournals(): List<Journal> {
        return withContext(Dispatchers.IO) {
            val result = postgrest.from("journal")
                .select().decodeList<JournalDto>().map { it.toDomain() }
            result
        }
    }
}