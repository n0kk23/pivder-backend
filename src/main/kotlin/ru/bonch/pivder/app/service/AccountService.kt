package ru.bonch.pivder.app.service

import ru.bonch.pivder.app.entity.AccountEntity
import java.util.UUID

interface AccountService {
    fun findAccountById(id: UUID): AccountEntity
}