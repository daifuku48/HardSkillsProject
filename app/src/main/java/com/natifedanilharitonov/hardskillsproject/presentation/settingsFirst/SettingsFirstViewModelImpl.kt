package com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.settingsFirst.SettingsFirstEvent
import com.natifedanilharitonov.domain.features.settingsFirst.SettingsFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class SettingsFirstViewModelImpl(
    reducer: Reducer<SettingsFirstState, SettingsFirstEvent, SettingsFirstUiState>,
    useCases: Set<UseCase<SettingsFirstState, SettingsFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<SettingsFirstState, SettingsFirstEvent, SettingsFirstUiState>(
        reducer,
        useCases,
        navigator,
    ),
    SettingsFirstViewModel {
    init {
        handleEvent(SettingsFirstEvent.GetTextEvent)
    }

    override fun createInitState(): SettingsFirstState = SettingsFirstState()

    override fun navigateToNextScreen() {
        navigate(Screen.SettingsSecondScreen.route)
    }
}
