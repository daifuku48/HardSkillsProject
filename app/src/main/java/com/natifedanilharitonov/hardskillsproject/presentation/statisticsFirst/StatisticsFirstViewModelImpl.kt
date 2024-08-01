package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstEvent
import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstState

class StatisticsFirstViewModelImpl(
    reducer: Reducer<StatisticsFirstState, StatisticsFirstEvent>,
    useCases: Set<UseCase<StatisticsFirstState, StatisticsFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<StatisticsFirstState, StatisticsFirstEvent, StatisticsFirstUiState>(
    reducer,
    useCases,
    navigator,
),
    StatisticsFirstViewModel {
    init {
        handleEvent(StatisticsFirstEvent.GetStatsModel)
    }

    override fun mapToUiModel(state: StatisticsFirstState): StatisticsFirstUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: StatisticsFirstEvent) {}

    override fun navigateToNextScreen() {
        navigate(Screen.StatisticsSecondScreen.route)
    }

    override fun getModelStats() {
        handleEvent(StatisticsFirstEvent.GetStatsModel)
    }

    override fun popBackScreen() {
        popBack()
    }
}
