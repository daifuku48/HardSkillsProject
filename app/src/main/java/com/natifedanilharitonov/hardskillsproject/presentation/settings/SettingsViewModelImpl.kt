package com.natifedanilharitonov.hardskillsproject.presentation.settings

import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.settings.SettingsEvent
import com.natifedanilharitonov.domain.use_cases.settings.SettingsState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class SettingsViewModelImpl(
    reducer: Reducer<SettingsState, SettingsEvent, SettingsUiState>,
    useCases: Set<UseCase<SettingsState, SettingsEvent>>,
    navigator: Navigator
) : BaseViewModel<SettingsState, SettingsEvent, SettingsUiState>(reducer, useCases, navigator),
    SettingsViewModel {
    override fun createInitState(): SettingsState =
        SettingsState()

    override fun signOut() {
        handleEvent(SettingsEvent.SignOutUserEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.SettingFirstScreen.route)
    }

    override fun navigateToLogin() {
        val navOptions = NavOptions
            .Builder()
            .setPopUpTo(Screen.SettingsScreen.route, true)
            .build()
        navigate(Screen.LoginScreen.route, navOptions)
    }
}