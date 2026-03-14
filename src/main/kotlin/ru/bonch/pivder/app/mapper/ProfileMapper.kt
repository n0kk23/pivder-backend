package ru.bonch.pivder.app.mapper

import org.springframework.stereotype.Component
import ru.bonch.pivder.app.dto.response.ProfileResponseDto
import ru.bonch.pivder.app.entity.ProfileEntity

@Component
class ProfileMapper {
    fun toResponse(profileEntity: ProfileEntity): ProfileResponseDto {
        return ProfileResponseDto(
            profileEntity.gender,
            profileEntity.preferGender,
            profileEntity.description,
            profileEntity.universityGroup
        )
    }
}