package ru.bonch.pivder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.bonch.pivder.config.JwtConfiguration

@SpringBootApplication
@EnableConfigurationProperties(JwtConfiguration::class)
class PivderApplication

fun main(args: Array<String>) {
	runApplication<PivderApplication>(*args)
}
