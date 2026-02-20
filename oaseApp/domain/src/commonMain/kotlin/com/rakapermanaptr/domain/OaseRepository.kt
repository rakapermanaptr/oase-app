package com.rakapermanaptr.domain

import com.rakapermanaptr.domain.home.entity.Journal

interface OaseRepository {
    suspend fun getJournals(): List<Journal>
}