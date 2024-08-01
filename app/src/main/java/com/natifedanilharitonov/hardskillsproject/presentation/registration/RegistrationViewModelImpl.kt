package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.registration.RegistrationEvent
import com.natifeuaandroid.domainmodule.features.registration.RegistrationState

class RegistrationViewModelImpl(
    reducer: Reducer<RegistrationState, RegistrationEvent>,
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

    override fun mapToUiModel(state: RegistrationState): RegistrationUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: RegistrationEvent) {}

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
            NavOptions
                .Builder()
                .setPopUpTo(Screen.RegistrationScreen.route, inclusive = true)
                .setLaunchSingleTop(true)
                .build()
        navigate(Screen.LoginScreen.route, navOptions)
    }

    override fun onConfirmErrorDialog() {
        handleEvent(RegistrationEvent.HideUserErrorRegistrationDialog)
    }

    override fun onConfirmUserRegisteredDialog() {
        handleEvent(RegistrationEvent.HideUserHasRegisteredDialog)
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(Screen.RegistrationScreen.route, inclusive = true)
                .build()
        navigate(Screen.MainScreen.route, navOptions)
    }
}
