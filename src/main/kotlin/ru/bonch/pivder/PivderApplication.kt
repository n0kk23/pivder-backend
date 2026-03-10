package ru.bonch.pivder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.bonch.pivder.config.JwtConfiguration
import ru.bonch.pivder.config.TokenHashAlgorithmConfiguration

@SpringBootApplication
@EnableConfigurationProperties(
	JwtConfiguration::class,
	TokenHashAlgorithmConfiguration::class
)
class PivderApplication

fun main(args: Array<String>) {
	runApplication<PivderApplication>(*args)
}
