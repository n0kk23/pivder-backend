package ru.bonch.pivder.app.command

data class AccountAuthorizationCommand(
    val username: String,
    val password: String
)