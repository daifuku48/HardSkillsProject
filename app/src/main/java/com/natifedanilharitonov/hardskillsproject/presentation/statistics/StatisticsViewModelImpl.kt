package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class StatisticsViewModelImpl(
    reducer: Reducer<StatisticsState, StatisticsEvent>,
    useCases: Set<UseCase<StatisticsState, StatisticsEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsState, StatisticsEvent>(reducer, useCases, navigator),
    StatisticsViewModel {
    override fun createInitState(): StatisticsState = StatisticsState()
}