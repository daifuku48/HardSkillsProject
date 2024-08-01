package com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstEvent
import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstState

class SettingsFirstViewModelImpl(
    reducer: Reducer<SettingsFirstState, SettingsFirstEvent>,
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

    override fun mapToUiModel(state: SettingsFirstState): SettingsFirstUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: SettingsFirstEvent) {}

    override fun navigateToNextScreen() {
        navigate(Screen.SettingsSecondScreen.route)
    }
}
