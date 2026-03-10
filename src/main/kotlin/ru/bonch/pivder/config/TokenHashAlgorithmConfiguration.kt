package ru.bonch.pivder.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "token")
class TokenHashAlgorithmConfiguration (
    val hashAlgorithm: String
)