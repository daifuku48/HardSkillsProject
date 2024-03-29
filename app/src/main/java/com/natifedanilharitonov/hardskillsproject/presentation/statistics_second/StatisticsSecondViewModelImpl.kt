package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.statistics_second.StatisticsSecondEvent
import com.natifedanilharitonov.domain.use_cases.statistics_second.StatisticsSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model.StatisticsSecondUiState

class StatisticsSecondViewModelImpl(
    reducer: Reducer<StatisticsSecondState, StatisticsSecondEvent, StatisticsSecondUiState>,
    useCases: Set<UseCase<StatisticsSecondState, StatisticsSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<StatisticsSecondState, StatisticsSecondEvent, StatisticsSecondUiState>(
    reducer,
    useCases,
    navigator
),
    StatisticsSecondViewModel {
    init {
        handleEvent(StatisticsSecondEvent.GetDataModelEvent)
    }

    override fun createInitState(): StatisticsSecondState =
        StatisticsSecondState()

    override fun navigateToMainChart() {
        val navOptions =
            NavOptions.Builder()
                .setPopUpTo(Screen.StatisticsSecondScreen.route, true)
                .build()
        navigate(Screen.StatisticsScreen.route, navOptions)
    }
}