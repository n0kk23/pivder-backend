package ru.bonch.pivder.app.service

import ru.bonch.pivder.app.dto.request.CreateProfileRequestDto
import ru.bonch.pivder.app.dto.response.ProfileResponseDto
import ru.bonch.pivder.app.entity.ProfileEntity
import java.util.UUID

interface ProfileService {
    fun createProfile(accountId: UUID, request: CreateProfileRequestDto)
    fun findByAccountId(accountId: UUID): ProfileResponseDto
}