package ru.bonch.pivder.app.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.bonch.pivder.app.entity.AccountEntity
import ru.bonch.pivder.app.entity.LikeEntity
import ru.bonch.pivder.app.enums.LikeStatus
import java.util.*

interface LikeRepository : JpaRepository<LikeEntity, UUID> {
    fun findAllByLikedAndStatus(liked: AccountEntity, status: LikeStatus): List<LikeEntity>
}