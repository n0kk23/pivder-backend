package ru.bonch.pivder.app.exception.conflict

open class ConflictException(
    override val message: String
) : RuntimeException()