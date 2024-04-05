package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.statistics.StatisticsEvent
import com.natifedanilharitonov.domain.features.statistics.StatisticsState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class StatisticsViewModelImpl(
    reducer: Reducer<StatisticsState, StatisticsEvent, StatisticsUiState>,
    useCases: Set<UseCase<StatisticsState, StatisticsEvent>>,
    navigator: Navigator,
) : BaseViewModel<StatisticsState, StatisticsEvent, StatisticsUiState>(
        reducer,
        useCases,
        navigator,
    ),
    StatisticsViewModel {
    init {
        handleEvent(StatisticsEvent.GetModelStatsEvent)
    }

    override fun createInitState(): StatisticsState = StatisticsState()

    fun navigateToNextScreen() {
        navigate(Screen.StatisticsFirstScreen.route)
    }
}
