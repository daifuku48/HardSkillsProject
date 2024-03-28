package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class StatisticsFirstViewModelImpl(
    reducer: Reducer<StatisticsFirstState, StatisticsFirstEvent>,
    useCases: Set<UseCase<StatisticsFirstState, StatisticsFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsFirstState, StatisticsFirstEvent>(reducer, useCases, navigator),
    StatisticsFirstViewModel {
    init {
        handleEvent(StatisticsFirstEvent.GetStatsModel)
    }

    override fun createInitState(): StatisticsFirstState = StatisticsFirstState()
    override fun navigateToNextScreen() {
        navigate(Screen.StatisticsSecondScreen.route)
    }

    override fun getModelStats() {
        handleEvent(StatisticsFirstEvent.GetStatsModel)
    }
}