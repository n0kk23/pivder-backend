package ru.bonch.pivder.app.exception.notfound.impl

import ru.bonch.pivder.app.exception.notfound.NotFoundException

class ProfileNotFoundException(
    override val message: String
) : NotFoundException(message)