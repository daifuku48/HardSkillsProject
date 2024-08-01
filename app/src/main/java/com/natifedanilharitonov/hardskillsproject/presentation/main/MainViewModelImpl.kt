package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.main.MainEvent
import com.natifeuaandroid.domainmodule.features.main.MainState

class MainViewModelImpl(
    reducer: Reducer<MainState, MainEvent>,
    useCases: Set<UseCase<MainState, MainEvent>>,
    navigator: Navigator,
) : BaseViewModel<MainState, MainEvent, MainUiState>(reducer, useCases, navigator),
    MainViewModel {
    init {
        handleEvent(MainEvent.GetMainTextEvent)
    }
    override fun mapToUiModel(state: MainState): MainUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: MainEvent) {}

    override fun navigateToNextScreen() {
        navigate(Screen.MainFirstMockScreen.route)
    }
}
