package com.rakapermanaptr.data.features.home.model

import com.rakapermanaptr.domain.home.entity.Journal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JournalDto(
    @SerialName("id")
    val id: Int,
    @SerialName("journal")
    val journal: String
)

fun JournalDto.toDomain(): Journal = Journal(id = id, journal = journal)
