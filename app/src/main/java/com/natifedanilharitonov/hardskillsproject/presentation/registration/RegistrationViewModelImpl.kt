package com.natifedanilharitonov.hardskillsproject.presentation.registration

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
    override fun createInitState(): RegistrationState = RegistrationState()

    override fun handleCaughtEvent(event: RegistrationEvent) {}

    override fun nicknameChanged(nickname: String) {
        handleEvent(RegistrationEvent.NicknameChangedEvent(nickname))
        handleEvent(RegistrationEvent.NicknameValidationEvent)
    }

    override fun emailChanged(email: String) {
        handleEvent(RegistrationEvent.EmailChangedEvent(email))
        handleEvent(RegistrationEvent.EmailValidationEvent)
    }

    override fun passwordChanged(password: String) {
        handleEvent(RegistrationEvent.PasswordChangedEvent(password))
        handleEvent(RegistrationEvent.PasswordValidationEvent)
    }

    override fun register() {
        handleEvent(RegistrationEvent.RegisterUserEvent)
    }

    override fun navigateToLogin() {
        navigate(Screen.LoginScreen.route)
    }
}