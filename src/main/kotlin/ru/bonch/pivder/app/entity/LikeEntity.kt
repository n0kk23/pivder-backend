package ru.bonch.pivder.app.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import ru.bonch.pivder.app.enums.LikeStatus
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(name = "likes")
class LikeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "liker_id", nullable = false)
    var liker: AccountEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "liked_id", nullable = false)
    var liked: AccountEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: LikeStatus = LikeStatus.PENDING,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    var createdAt: OffsetDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    var updatedAt: OffsetDateTime? = null,
)