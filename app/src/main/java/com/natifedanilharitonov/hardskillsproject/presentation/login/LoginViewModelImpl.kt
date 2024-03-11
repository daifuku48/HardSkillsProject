package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class LoginViewModelImpl(
    reducer: Reducer<LoginState, LoginEvent>,
    useCases: Set<UseCase<LoginState, LoginEvent>>,
    navigator: Navigator
) : BaseViewModel<LoginState, LoginEvent>(reducer, useCases, navigator), LoginViewModel {
    init {
        handleEvent(LoginEvent.ValidationEvent)
    }

    override fun createInitState(): LoginState = LoginState()

    override fun handleCaughtEvent(event: LoginEvent) {}

    override fun onEmailChanged(email: String) {
        handleEvent(LoginEvent.EmailChangedEvent(email = email))
        handleEvent(LoginEvent.ValidationEvent)
    }

    override fun onPasswordChanged(password: String) {
        handleEvent(LoginEvent.PasswordChangedEvent(password = password))
        handleEvent(LoginEvent.ValidationEvent)
    }

    override fun navigateToRegister() {
        val navOptions =
            NavOptions.Builder().setPopUpTo(Screen.LoginScreen.route, inclusive = true).build()
        navigate(Screen.RegistrationScreen.route, navOptions)
    }

    override fun login() {
        handleEvent(LoginEvent.LoginUserEvent)
    }

    override fun onConfirmUserHasLoggedDialog() {
        handleEvent(LoginEvent.HideUserHasLoggedDialog)
        navigateToMainScreen()
    }

    override fun onConfirmErrorUserDialog() {
        handleEvent(LoginEvent.HideUserErrorLoginDialog)
        handleEvent(LoginEvent.ClearTextFields)
    }

    private fun navigateToMainScreen() {
        val navOptions =
            NavOptions.Builder().setPopUpTo(Screen.LoginScreen.route, inclusive = true).build()
        navigate(Screen.MainScreen.route, navOptions)
    }
}

