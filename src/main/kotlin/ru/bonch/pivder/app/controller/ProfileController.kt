package ru.bonch.pivder.app.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import ru.bonch.pivder.app.dto.request.CreateProfileRequestDto
import ru.bonch.pivder.app.dto.response.ProfileResponseDto
import ru.bonch.pivder.app.service.ProfileService
import ru.bonch.pivder.app.userdetails.UserDetailsImpl

@RestController
@RequestMapping("/api/v1/profiles")
class ProfileController(
    private val profileService: ProfileService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProfile(
        @AuthenticationPrincipal user: UserDetailsImpl,
        @RequestBody @Valid request: CreateProfileRequestDto
    ) {
        profileService.createProfile(user.getId(), request)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getProfile(
        @AuthenticationPrincipal user: UserDetailsImpl
    ): ProfileResponseDto {
        return profileService.findByAccountId(user.getId())
    }
}