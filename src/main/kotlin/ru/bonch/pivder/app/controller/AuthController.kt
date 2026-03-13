package ru.bonch.pivder.app.controller

import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.bonch.pivder.app.command.AccountAuthorizationCommand
import ru.bonch.pivder.app.command.AccountRegistrationCommand
import ru.bonch.pivder.app.dto.request.AccountAuthorizationRequestDto
import ru.bonch.pivder.app.dto.request.AccountRegistrationRequestDto
import ru.bonch.pivder.app.dto.response.AccountResponseDto
import ru.bonch.pivder.app.dto.response.TokenResponseDto
import ru.bonch.pivder.app.service.AuthService

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {

    companion object {
        private val log = LoggerFactory.getLogger(AuthController::class.java)
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun registration(
        @RequestBody @Valid request: AccountRegistrationRequestDto
    ) {
        log.debug("AccountRegistrationRequestDto: {}", request)

        authService.registration(
            AccountRegistrationCommand(
                username = request.username,
                password = request.password
            )
        )
    }

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    fun authorization(
        @RequestBody @Valid request: AccountAuthorizationRequestDto
    ): TokenResponseDto {
        return authService.authorization(
            AccountAuthorizationCommand(
                username = request.username,
                password = request.password
            )
        )
    }
}