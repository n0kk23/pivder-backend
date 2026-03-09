package ru.bonch.pivder.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtConfiguration (
    val secretKey: String,
    val accessTokenExpirationMs: Long,
    val refreshTokenExpirationMs: Long
)