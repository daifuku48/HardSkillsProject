package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.statistics_first.StatisticsFirstEvent
import com.natifedanilharitonov.domain.use_cases.statistics_first.StatisticsFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class StatisticsFirstViewModelImpl(
    reducer: Reducer<StatisticsFirstState, StatisticsFirstEvent, StatisticsFirstUiState>,
    useCases: Set<UseCase<StatisticsFirstState, StatisticsFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsFirstState, StatisticsFirstEvent, StatisticsFirstUiState>(
    reducer,
    useCases,
    navigator
),
    StatisticsFirstViewModel {
    init {
        handleEvent(StatisticsFirstEvent.GetStatsModel)
    }

    override fun createInitState(): StatisticsFirstState =
        StatisticsFirstState()

    override fun navigateToNextScreen() {
        navigate(Screen.StatisticsSecondScreen.route)
    }

    override fun getModelStats() {
        handleEvent(StatisticsFirstEvent.GetStatsModel)
    }
}