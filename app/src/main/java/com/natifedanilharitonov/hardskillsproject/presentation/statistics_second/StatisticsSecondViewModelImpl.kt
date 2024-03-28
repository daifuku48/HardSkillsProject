package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class StatisticsSecondViewModelImpl(
    reducer: Reducer<StatisticsSecondState, StatisticsSecondEvent>,
    useCases: Set<UseCase<StatisticsSecondState, StatisticsSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsSecondState, StatisticsSecondEvent>(reducer, useCases, navigator),
    StatisticsSecondViewModel {
    init {
        handleEvent(StatisticsSecondEvent.GetDataModelEvent)
    }

    override fun createInitState(): StatisticsSecondState = StatisticsSecondState()

    override fun navigateToMainChart() {
        val navOptions =
            NavOptions.Builder()
                .setPopUpTo(Screen.StatisticsSecondScreen.route, true)
                .build()
        navigate(Screen.StatisticsScreen.route, navOptions)
    }
}