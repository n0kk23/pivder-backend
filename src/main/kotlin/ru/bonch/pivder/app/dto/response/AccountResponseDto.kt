package ru.bonch.pivder.app.dto.response

import java.time.OffsetDateTime
import java.util.UUID

data class AccountResponseDto(
    val id: UUID,
    val username: String,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime
)