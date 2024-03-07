package com.natifedanilharitonov.hardskillsproject.presentation.registration

interface RegistrationViewModel {
    fun nicknameChanged(nickname: String)
    fun emailChanged(email: String)
    fun passwordChanged(password: String)
    fun register()
    fun navigateToLogin()
}