package ru.bonch.pivder.app.dto.response

data class TokenResponseDto(
    val accessToken: String,
    val refreshToken: String
)
