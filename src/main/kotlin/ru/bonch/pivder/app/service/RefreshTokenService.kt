package ru.bonch.pivder.app.service

import ru.bonch.pivder.app.entity.AccountEntity

interface RefreshTokenService {
    fun generateRefreshToken(account: AccountEntity): String
}