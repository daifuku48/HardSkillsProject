package com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondEvent
import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondState

class SettingsSecondViewModelImpl(
    reducer: Reducer<SettingsSecondState, SettingsSecondEvent>,
    useCases: Set<UseCase<SettingsSecondState, SettingsSecondEvent>>,
    navigator: Navigator,
) : BaseViewModel<SettingsSecondState, SettingsSecondEvent, SettingsSecondUiState>(
    reducer,
    useCases,
    navigator,
),
    SettingsSecondViewModel {
    init {
        handleEvent(SettingsSecondEvent.GetTextEvent)
    }

    override fun mapToUiModel(state: SettingsSecondState): SettingsSecondUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: SettingsSecondEvent) {}

    override fun backToStart() {
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(Screen.SettingsSecondScreen.route, true)
                .build()
        navigate(Screen.SettingsScreen.route, navOptions)
    }
}
