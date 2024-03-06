package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class LoginViewModelBase(
    reducer: Reducer<LoginState, LoginEvent>,
    useCases: Set<UseCase<LoginState, LoginEvent>>,
    navigator: Navigator
) : BaseViewModel<LoginState, LoginEvent>(reducer, useCases, navigator), LoginViewModel {
    override fun createInitState(): LoginState = LoginState()

    override fun handleCaughtEvent(event: LoginEvent) {}

    override fun onEmailChanged(email: String) {
        handleEvent(LoginEvent.EmailChangedEvent(email = email))
    }

    override fun onPasswordChanged(password: String) {
        handleEvent(LoginEvent.PasswordChangedEvent(password = password))
    }

    override fun navigateToRegister() {
        navigate(Screen.RegistrationScreen.route)
    }

    override fun login() {
        handleEvent(LoginEvent.LoginUserEvent)
    }
}

