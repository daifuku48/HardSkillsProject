package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class SettingsFirstViewModelImpl(
    reducer: Reducer<SettingsFirstState, SettingsFirstEvent>,
    useCases: Set<UseCase<SettingsFirstState, SettingsFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<SettingsFirstState, SettingsFirstEvent>(reducer, useCases, navigator),
    SettingsFirstViewModel {
    init {
        handleEvent(SettingsFirstEvent.GetTextEvent)
    }

    override fun createInitState(): SettingsFirstState = SettingsFirstState()
    override fun navigateToNextScreen() {
        navigate(Screen.SettingsSecondScreen.route)
    }
}