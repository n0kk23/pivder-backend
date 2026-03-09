package ru.bonch.pivder.app.exception.notfound

open class NotFoundException(
    override val message: String
) : RuntimeException()