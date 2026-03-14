package ru.bonch.pivder.app.service.impl

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.bonch.pivder.app.dto.request.AccountAuthorizationRequestDto
import ru.bonch.pivder.app.dto.request.AccountRegistrationRequestDto
import ru.bonch.pivder.app.dto.response.AccountResponseDto
import ru.bonch.pivder.app.dto.response.TokenResponseDto
import ru.bonch.pivder.app.entity.AccountEntity
import ru.bonch.pivder.app.exception.conflict.impl.UsernameIsAlreadyTakenException
import ru.bonch.pivder.app.exception.unauthorized.impl.BadCredentialsException
import ru.bonch.pivder.app.mapper.AccountMapper
import ru.bonch.pivder.app.repository.AccountRepository
import ru.bonch.pivder.app.service.AuthService
import ru.bonch.pivder.app.service.TokenService

@Service
class AuthServiceImpl(
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
    private val tokenService: TokenService,
    private val accountMapper: AccountMapper,
) : AuthService {

    @Transactional
    override fun registration(request: AccountRegistrationRequestDto): AccountResponseDto {
        if (accountRepository.existsByUsername(request.username)) {
            throw UsernameIsAlreadyTakenException("Username '${request.username}' is already taken")
        }

        val account = AccountEntity(
            username = request.username,
            hashPassword = passwordEncoder.encode(request.password),
        )

        val savedAccount = accountRepository.save(account)

        return accountMapper.toResponse(savedAccount)
    }

    @Transactional
    override fun authorization(request: AccountAuthorizationRequestDto): TokenResponseDto {
        val account: AccountEntity = accountRepository.findByUsername(request.username)
            ?: throw BadCredentialsException("Wrong username or password")

        if (!passwordEncoder.matches(request.password, account.hashPassword)) {
            throw BadCredentialsException("Wrong username or password")
        }

        val accessToken = tokenService.generateAccessToken(account)
        val refreshToken = tokenService.generateRefreshToken(account)

        return TokenResponseDto(accessToken, refreshToken)
    }
}