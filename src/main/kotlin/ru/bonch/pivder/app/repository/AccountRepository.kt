package ru.bonch.pivder.app.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.bonch.pivder.app.entity.AccountEntity
import java.util.*

interface AccountRepository : JpaRepository<AccountEntity, UUID> {
    fun existsByUsername(username: String): Boolean
    fun findByUsername(username: String): AccountEntity?
}