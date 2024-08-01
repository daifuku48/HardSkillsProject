package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.login.LoginEvent
import com.natifeuaandroid.domainmodule.features.login.LoginState

class LoginViewModelImpl(
    reducer: Reducer<LoginState, LoginEvent>,
    useCases: Set<UseCase<LoginState, LoginEvent>>,
    navigator: Navigator,
) : BaseViewModel<LoginState, LoginEvent, LoginUiState>(reducer, useCases, navigator),
    LoginViewModel {
    init {
        handleEvent(LoginEvent.ValidationEvent)
    }

    override fun mapToUiModel(state: LoginState): LoginUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: LoginEvent) {}

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
            NavOptions
                .Builder()
                .setPopUpTo(Screen.LoginScreen.route, inclusive = true)
                .setLaunchSingleTop(true)
                .build()
        navigate(Screen.MainScreen.route, navOptions)
    }
}
