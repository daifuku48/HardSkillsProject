package com.natifedanilharitonov.hardskillsproject.presentation.registration

interface RegistrationViewModel {
    fun emailChanged(email: String)

    fun passwordChanged(password: String)

    fun register()

    fun navigateToLogin()

    fun onConfirmErrorDialog()

    fun onConfirmUserRegisteredDialog()
}
