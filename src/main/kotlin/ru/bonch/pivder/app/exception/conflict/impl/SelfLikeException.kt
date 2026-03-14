package ru.bonch.pivder.app.exception.conflict.impl

import ru.bonch.pivder.app.exception.conflict.ConflictException

class SelfLikeException(
    override val message: String
) : ConflictException(message)