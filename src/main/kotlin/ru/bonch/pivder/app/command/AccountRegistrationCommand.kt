package ru.bonch.pivder.app.command

data class AccountRegistrationCommand(
    val username: String,
    val password: String
)