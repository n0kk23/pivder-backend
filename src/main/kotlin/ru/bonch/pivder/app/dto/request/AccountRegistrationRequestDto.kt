package ru.bonch.pivder.app.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AccountRegistrationRequestDto(
    @field:NotBlank(message = "username can't be blank")
    @field:Size(min = 6, max = 24, message = "username size must be from 6 to 24 characters")
    val username: String,

    @field:NotBlank(message = "password can't be blank")
    @field:Size(min = 8, max = 24, message = "password size must be from 8 to 24 characters")
    val password: String
)