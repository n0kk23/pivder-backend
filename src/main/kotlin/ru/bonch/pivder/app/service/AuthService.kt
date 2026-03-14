package ru.bonch.pivder.app.service

import ru.bonch.pivder.app.dto.request.AccountAuthorizationRequestDto
import ru.bonch.pivder.app.dto.request.AccountRegistrationRequestDto
import ru.bonch.pivder.app.dto.response.AccountResponseDto
import ru.bonch.pivder.app.dto.response.TokenResponseDto

interface AuthService {
    fun registration(request: AccountRegistrationRequestDto): AccountResponseDto
    fun authorization(request: AccountAuthorizationRequestDto): TokenResponseDto
}