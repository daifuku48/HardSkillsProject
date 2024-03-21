package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class SettingsSecondViewModelImpl(
    reducer: Reducer<SettingsSecondState, SettingsSecondEvent>,
    useCases: Set<UseCase<SettingsSecondState, SettingsSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<SettingsSecondState, SettingsSecondEvent>(reducer, useCases, navigator),
    SettingsSecondViewModel {
    init {
        handleEvent(SettingsSecondEvent.GetTextEvent)
    }

    override fun createInitState(): SettingsSecondState = SettingsSecondState()
    override fun backToStart() {
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(Screen.SettingsSecondScreen.route, true)
                .build()
        navigate(Screen.SettingsScreen.route, navOptions)
    }
}