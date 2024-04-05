package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main.MainEvent
import com.natifedanilharitonov.domain.features.main.MainState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class MainViewModelImpl(
    reducer: Reducer<MainState, MainEvent, MainUiState>,
    useCases: Set<UseCase<MainState, MainEvent>>,
    navigator: Navigator,
) : BaseViewModel<MainState, MainEvent, MainUiState>(reducer, useCases, navigator), MainViewModel {
    init {
        handleEvent(MainEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainState = MainState()

    override fun navigateToNextScreen() {
        navigate(Screen.MainFirstMockScreen.route)
    }
}
