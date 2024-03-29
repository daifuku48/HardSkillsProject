package com.natifedanilharitonov.domain.use_cases.registration


import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.use_cases.login.model.PasswordValidationResult

data class RegistrationState(
    val email: String = "",
    val password: String = "",
    val emailLabel: EmailValidationResult = EmailValidationResult.ValidEmail,
    val passwordLabel: PasswordValidationResult = PasswordValidationResult.ValidPassword,
    val pending: Boolean = false,
    val registerButtonEnabled: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorRegisterDialog: Boolean = false
) : UiState