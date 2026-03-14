package ru.bonch.pivder.app.dto.request

import ru.bonch.pivder.app.enums.Gender
import ru.bonch.pivder.app.enums.PreferGender

data class CreateProfileRequestDto(
    val gender: Gender,
    val preferGender: PreferGender,
    val description: String,
    val universityGroup: String
)