package ru.bonch.pivder.app.service.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.bonch.pivder.app.dto.request.CreateProfileRequestDto
import ru.bonch.pivder.app.dto.response.ProfileResponseDto
import ru.bonch.pivder.app.entity.AccountEntity
import ru.bonch.pivder.app.entity.ProfileEntity
import ru.bonch.pivder.app.exception.conflict.impl.MultiProfileException
import ru.bonch.pivder.app.exception.notfound.impl.ProfileNotFoundException
import ru.bonch.pivder.app.mapper.ProfileMapper
import ru.bonch.pivder.app.repository.ProfileRepository
import ru.bonch.pivder.app.service.AccountService
import ru.bonch.pivder.app.service.ProfileService
import java.util.*

@Service
class ProfileServiceImpl(
    private val profileRepository: ProfileRepository,
    private val accountService: AccountService,
    private val profileMapper: ProfileMapper
) : ProfileService {

    companion object {
        private val log = LoggerFactory.getLogger(ProfileService::class.java)
    }

    @Transactional
    override fun createProfile(accountId: UUID, request: CreateProfileRequestDto) {
        val account = accountService.findAccountById(accountId)

        if (profileRepository.existsByAccount(account)) {
            throw MultiProfileException("Can be only one profile per account")
        }

        val profile = ProfileEntity(
            account = account,
            gender = request.gender,
            preferGender = request.preferGender,
            description = request.description,
            universityGroup = request.universityGroup
        )

        log.debug("profile: {}", profile)

        profileRepository.save(profile)
    }

    @Transactional(readOnly = true)
    override fun findByAccountId(accountId: UUID): ProfileResponseDto {
        val account: AccountEntity = accountService.findAccountById(accountId)

        val profile = profileRepository.findByAccount(account)
            ?: throw ProfileNotFoundException("Profile is not founded by account: $account")

        return profileMapper.toResponse(profile)
    }
}