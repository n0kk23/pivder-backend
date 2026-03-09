package ru.bonch.pivder.app.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import ru.bonch.pivder.config.JwtConfiguration
import java.time.Instant
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtProvider(
    private val jwtConfiguration: JwtConfiguration
) {
    private val secretKey: SecretKey by lazy {
        Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtConfiguration.secretKey))
    }

    fun generateAccessToken(userId: UUID): String {
        return generateToken(userId, jwtConfiguration.accessTokenExpirationMs)
    }

    fun generateRefreshToken(userId: UUID): String {
        return generateToken(userId, jwtConfiguration.refreshTokenExpirationMs)
    }

    fun extractUserIdFromToken(token: String): UUID =
        UUID.fromString(parseClaims(token).subject)

    fun extractExpiresAtFromToken(token: String): Date =
        parseClaims(token).expiration

    fun validateToken(token: String): Boolean = runCatching {
        parseClaims(token)
    }.isSuccess

    private fun parseClaims(token: String) =
        Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload


    private fun generateToken(userId: UUID, expirationMs: Long): String {
        val now = Instant.now()

        return Jwts.builder()
            .subject(userId.toString())
            .issuedAt(Date.from(now))
            .expiration(
                Date.from(now.plusMillis(expirationMs))
            )
            .signWith(secretKey)
            .compact()
    }
}