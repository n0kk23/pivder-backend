package ru.bonch.pivder.app.exception.unauthorized

open class UnauthorizedException(
    override val message: String
) : RuntimeException() {
}