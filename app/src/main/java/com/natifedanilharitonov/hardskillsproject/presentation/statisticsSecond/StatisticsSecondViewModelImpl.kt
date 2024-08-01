package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondEvent
import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondState

class StatisticsSecondViewModelImpl(
    reducer: Reducer<StatisticsSecondState, StatisticsSecondEvent>,
    useCases: Set<UseCase<StatisticsSecondState, StatisticsSecondEvent>>,
    navigator: Navigator,
) : BaseViewModel<StatisticsSecondState, StatisticsSecondEvent, StatisticsSecondUiState>(
    reducer,
    useCases,
    navigator,
),
    StatisticsSecondViewModel {
    init {
        handleEvent(StatisticsSecondEvent.GetDataModelEvent)
    }

    override fun mapToUiModel(state: StatisticsSecondState): StatisticsSecondUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: StatisticsSecondEvent) {}

    override fun navigateToMainChart() {
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(Screen.StatisticsSecondScreen.route, true)
                .build()
        navigate(Screen.StatisticsScreen.route, navOptions)
    }

    override fun popBackScreen() {
        popBack()
    }
}
