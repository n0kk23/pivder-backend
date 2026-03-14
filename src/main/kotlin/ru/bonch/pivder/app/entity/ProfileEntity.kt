package ru.bonch.pivder.app.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import ru.bonch.pivder.app.enums.Gender
import ru.bonch.pivder.app.enums.PreferGender
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(name = "profiles")
class ProfileEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    var id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "account_id")
    var account: AccountEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    var gender: Gender,

    @Enumerated(EnumType.STRING)
    @Column(name = "prefer_gender")
    var preferGender: PreferGender,

    @field:Size(min = 1, max = 255)
    @Column(name = "description", nullable = false)
    var description: String,

    @field:Size(min = 3, max = 20)
    @Column(name = "university_group", nullable = false)
    var universityGroup: String,

    @CreationTimestamp
    @Column(name = "created_at")
    var createdAt: OffsetDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    var updatedAt: OffsetDateTime? = null
) {
    override fun toString(): String {
        return "id: $id, account: ${account.id}, gender: $gender, preferGender: $preferGender, description: $description"
    }
}