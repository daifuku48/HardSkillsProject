package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class StatisticsViewModelImpl(
    reducer: Reducer<StatisticsState, StatisticsEvent>,
    useCases: Set<UseCase<StatisticsState, StatisticsEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsState, StatisticsEvent>(reducer, useCases, navigator),
    StatisticsViewModel {
    init {
        handleEvent(StatisticsEvent.GetModelStatsEvent)
    }

    override fun createInitState(): StatisticsState = StatisticsState()

    fun navigateToNextScreen() {
        navigate(Screen.StatisticsFirstScreen.route)
    }
}