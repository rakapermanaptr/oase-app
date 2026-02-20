package com.rakapermanaptr.domain.home.repository

import com.rakapermanaptr.domain.home.entity.Journal

interface IHomeRepository {
    suspend fun getJournals(): List<Journal>
}