package com.natifedanilharitonov.hardskillsproject.presentation.settings

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.settings.SettingsEvent
import com.natifeuaandroid.domainmodule.features.settings.SettingsState

class SettingsViewModelImpl(
    reducer: Reducer<SettingsState, SettingsEvent>,
    useCases: Set<UseCase<SettingsState, SettingsEvent>>,
    navigator: Navigator,
) : BaseViewModel<SettingsState, SettingsEvent, SettingsUiState>(reducer, useCases, navigator),
    SettingsViewModel {

    init {
        addSpecialEvent(SettingsEvent.UserIsSignedOutEvent::class)
    }

    override fun mapToUiModel(state: SettingsState): SettingsUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: SettingsEvent) {
        when (event) {
            SettingsEvent.UserIsSignedOutEvent -> navigateToLogin()
            else -> {}
        }
    }

    override fun signOut() {
        handleEvent(SettingsEvent.SignOutUserEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.SettingFirstScreen.route)
    }

    override fun navigateToLogin() {
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(Screen.MainScreen.route, inclusive = true)
                .setLaunchSingleTop(true)
                .build()
        navigate(Screen.LoginScreen.route, navOptions)
    }
}
