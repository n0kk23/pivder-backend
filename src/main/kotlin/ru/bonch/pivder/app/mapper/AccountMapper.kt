package ru.bonch.pivder.app.mapper

import org.springframework.stereotype.Component
import ru.bonch.pivder.app.dto.response.AccountResponseDto
import ru.bonch.pivder.app.entity.AccountEntity

@Component
class AccountMapper {

    fun toResponse(entity: AccountEntity): AccountResponseDto {
        return AccountResponseDto(
            id = entity.id!!,
            username = entity.username,
            createdAt = entity.createdAt!!,
            updatedAt = entity.updatedAt!!
        )
    }

}