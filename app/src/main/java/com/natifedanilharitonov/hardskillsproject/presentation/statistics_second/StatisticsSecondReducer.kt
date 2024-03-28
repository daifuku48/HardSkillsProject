package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class StatisticsSecondReducer : Reducer<StatisticsSecondState, StatisticsSecondEvent> {
    override fun reduce(
        state: StatisticsSecondState,
        event: StatisticsSecondEvent
    ): StatisticsSecondState {
        return when (event) {
            is StatisticsSecondEvent.DataModelIsReceivedEvent -> state.copy(model = event.model)
            is StatisticsSecondEvent.ErrorEvent -> state
            is StatisticsSecondEvent.GetDataModelEvent -> state
        }
    }
}