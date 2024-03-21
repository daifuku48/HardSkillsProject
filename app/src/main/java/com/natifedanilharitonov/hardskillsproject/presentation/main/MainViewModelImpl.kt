package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class MainViewModelImpl(
    reducer: Reducer<MainState, MainEvent>,
    useCases: Set<UseCase<MainState, MainEvent>>,
    navigator: Navigator
) : BaseViewModel<MainState, MainEvent>(reducer, useCases, navigator), MainViewModel {
    init {
        handleEvent(MainEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainState = MainState()

    override fun navigateToNextScreen() {
        navigate(Screen.MainFirstMockScreen.route)
    }
}