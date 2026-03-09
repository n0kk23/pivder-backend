package ru.bonch.pivder.app.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.bonch.pivder.app.entity.RefreshTokenEntity
import java.util.UUID

interface RefreshTokenRepository : JpaRepository<RefreshTokenEntity, UUID>