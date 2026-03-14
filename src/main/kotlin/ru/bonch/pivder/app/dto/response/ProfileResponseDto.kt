package ru.bonch.pivder.app.dto.response

import ru.bonch.pivder.app.enums.Gender
import ru.bonch.pivder.app.enums.PreferGender

data class ProfileResponseDto(
    val gender: Gender,
    val preferGender: PreferGender,
    val description: String,
    val universityGroup: String
)