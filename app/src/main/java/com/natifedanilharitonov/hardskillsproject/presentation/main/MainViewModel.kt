package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class MainViewModel(
    reducer: Reducer<MainState, MainEvent>,
    useCases: Set<UseCase<MainState, MainEvent>>,
    navigator: Navigator
) : BaseViewModel<MainState, MainEvent>(reducer, useCases, navigator) {
    override fun createInitState(): MainState = MainState()
    fun navigateToNextScreen() {

    }
}