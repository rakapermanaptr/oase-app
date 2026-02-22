package com.rakapermanaptr.domain.haven.repository

import com.rakapermanaptr.domain.haven.entity.Haven

interface IHavenRepository {

    suspend fun createHaven(userId: String): Result<String>
    suspend fun getHavenList(): Result<List<Haven>>
}