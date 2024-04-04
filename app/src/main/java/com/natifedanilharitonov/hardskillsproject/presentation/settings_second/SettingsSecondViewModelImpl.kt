package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.settings_second.SettingsSecondEvent
import com.natifedanilharitonov.domain.features.settings_second.SettingsSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class SettingsSecondViewModelImpl(
    reducer: Reducer<SettingsSecondState, SettingsSecondEvent, SettingsSecondUiState>,
    useCases: Set<UseCase<SettingsSecondState, SettingsSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<SettingsSecondState, SettingsSecondEvent, SettingsSecondUiState>(
    reducer,
    useCases,
    navigator
),
    SettingsSecondViewModel {
    init {
        handleEvent(SettingsSecondEvent.GetTextEvent)
    }

    override fun createInitState(): SettingsSecondState =
        SettingsSecondState()

    override fun backToStart() {
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(Screen.SettingsSecondScreen.route, true)
                .build()
        navigate(Screen.SettingsScreen.route, navOptions)
    }
}