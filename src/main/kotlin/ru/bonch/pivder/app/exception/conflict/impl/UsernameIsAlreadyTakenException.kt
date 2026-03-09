package ru.bonch.pivder.app.exception.conflict.impl

import ru.bonch.pivder.app.exception.conflict.ConflictException

class UsernameIsAlreadyTakenException(
    override val message: String
) : ConflictException(message)