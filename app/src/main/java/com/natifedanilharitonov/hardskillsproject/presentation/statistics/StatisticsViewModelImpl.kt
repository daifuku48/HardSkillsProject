package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.statistics.StatisticsEvent
import com.natifeuaandroid.domainmodule.features.statistics.StatisticsState

class StatisticsViewModelImpl(
    reducer: Reducer<StatisticsState, StatisticsEvent>,
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

    override fun mapToUiModel(state: StatisticsState): StatisticsUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: StatisticsEvent) {}

    override fun popBackScreen() {
        popBackStack(Screen.MainScreen.route, false)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.StatisticsFirstScreen.route)
    }
}
