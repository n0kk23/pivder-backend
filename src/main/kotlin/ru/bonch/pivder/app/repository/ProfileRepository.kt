package ru.bonch.pivder.app.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.bonch.pivder.app.entity.AccountEntity
import ru.bonch.pivder.app.entity.ProfileEntity
import java.util.*

interface ProfileRepository : JpaRepository<ProfileEntity, UUID> {
    fun existsByAccount(account: AccountEntity): Boolean
    fun findByAccount(account: AccountEntity): ProfileEntity?
}