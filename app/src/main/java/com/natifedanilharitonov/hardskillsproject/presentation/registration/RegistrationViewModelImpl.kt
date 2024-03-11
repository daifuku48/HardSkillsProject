package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class RegistrationViewModelImpl(
    reducer: Reducer<RegistrationState, RegistrationEvent>,
    useCases: Set<UseCase<RegistrationState, RegistrationEvent>>,
    navigator: Navigator
) : BaseViewModel<RegistrationState, RegistrationEvent>(reducer, useCases, navigator),
    RegistrationViewModel {
    init {
        handleEvent(RegistrationEvent.ValidationEvent)
    }

    override fun createInitState(): RegistrationState = RegistrationState()

    override fun handleCaughtEvent(event: RegistrationEvent) {}

    override fun emailChanged(email: String) {
        handleEvent(RegistrationEvent.EmailChangedEvent(email))
        handleEvent(RegistrationEvent.ValidationEvent)
    }

    override fun passwordChanged(password: String) {
        handleEvent(RegistrationEvent.PasswordChangedEvent(password))
        handleEvent(RegistrationEvent.ValidationEvent)
    }

    override fun register() {
        handleEvent(RegistrationEvent.RegisterUserEvent)
    }

    override fun navigateToLogin() {
        val navOptions =
            NavOptions.Builder().setPopUpTo(Screen.RegistrationScreen.route, inclusive = true)
                .build()
        navigate(Screen.LoginScreen.route, navOptions)
    }
}