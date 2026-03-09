package ru.bonch.pivder.app.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.bonch.pivder.app.entity.AccountEntity
import ru.bonch.pivder.app.entity.RefreshTokenEntity
import ru.bonch.pivder.app.jwt.JwtProvider
import ru.bonch.pivder.app.repository.RefreshTokenRepository
import ru.bonch.pivder.app.service.RefreshTokenService
import java.time.ZoneOffset
import java.util.*

@Service
// TODO make token service and all token logic here
class RefreshTokenServiceImpl(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProvider: JwtProvider
) : RefreshTokenService {

    @Transactional
    override fun generateRefreshToken(account: AccountEntity): String {
        val userId: UUID = requireNotNull(account.id) { "Account id must be not null" }
        val token = jwtProvider.generateRefreshToken(userId)

        val expiresAt = jwtProvider.extractExpiresAtFromToken(token)
            .toInstant()
            .atOffset(ZoneOffset.UTC)

        val refreshTokenEntity = RefreshTokenEntity(
            account = account,
            token = token,
            isActive = true,
            expiresAt = expiresAt
        )

        refreshTokenRepository.save(refreshTokenEntity)

        return token
    }
}