package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.registration.RegistrationEvent
import com.natifedanilharitonov.domain.features.registration.RegistrationState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class RegistrationViewModelImpl(
    reducer: Reducer<RegistrationState, RegistrationEvent, RegistrationUiState>,
    useCases: Set<UseCase<RegistrationState, RegistrationEvent>>,
    navigator: Navigator,
) : BaseViewModel<RegistrationState, RegistrationEvent, RegistrationUiState>(
        reducer,
        useCases,
        navigator,
    ),
    RegistrationViewModel {
    init {
        handleEvent(RegistrationEvent.ValidationEvent)
    }

    override fun createInitState(): RegistrationState = RegistrationState()

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
                .setLaunchSingleTop(true).build()
        navigate(Screen.LoginScreen.route, navOptions)
    }

    override fun onConfirmErrorDialog() {
        handleEvent(RegistrationEvent.HideUserErrorRegistrationDialog)
    }

    override fun onConfirmUserRegisteredDialog() {
        handleEvent(RegistrationEvent.HideUserHasRegisteredDialog)
        val navOptions =
            NavOptions.Builder().setPopUpTo(Screen.RegistrationScreen.route, inclusive = true)
                .build()
        navigate(Screen.MainScreen.route, navOptions)
    }
}
