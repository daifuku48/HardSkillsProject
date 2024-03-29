package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.statistics.StatisticsEvent
import com.natifedanilharitonov.domain.use_cases.statistics.StatisticsState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatisticsUiState

class StatisticsViewModelImpl(
    reducer: Reducer<StatisticsState, StatisticsEvent, StatisticsUiState>,
    useCases: Set<UseCase<StatisticsState, StatisticsEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsState, StatisticsEvent, StatisticsUiState>(
    reducer,
    useCases,
    navigator
),
    StatisticsViewModel {
    init {
        handleEvent(StatisticsEvent.GetModelStatsEvent)
    }

    override fun createInitState(): StatisticsState =
        StatisticsState()

    fun navigateToNextScreen() {
        navigate(Screen.StatisticsFirstScreen.route)
    }
}