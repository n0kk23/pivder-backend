package ru.bonch.pivder.app.exception.conflict.impl

import ru.bonch.pivder.app.exception.conflict.ConflictException

class MultiProfileException(
    override val message: String
) : ConflictException(message) {
}