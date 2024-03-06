package com.natifedanilharitonov.hardskillsproject.presentation.login

interface LoginViewModel {
    fun onEmailChanged(email: String)
    fun onPasswordChanged(password: String)
    fun navigateToRegister()
    fun login()
}