package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class MainActivityViewModel(
    reducer: MainActivityReducer,
    useCases: Set<UseCase<MainActivityState, MainActivityEvent>>,
    navigator: Navigator
) : BaseViewModel<MainActivityState, MainActivityEvent>(reducer, useCases, navigator) {
    override fun createInitState(): MainActivityState = MainActivityState()

    override fun handleCaughtEvent(event: MainActivityEvent) {}
}