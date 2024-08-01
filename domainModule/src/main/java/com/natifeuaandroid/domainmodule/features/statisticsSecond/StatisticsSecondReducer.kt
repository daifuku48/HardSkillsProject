package com.natifeuaandroid.domainmodule.features.statisticsSecond


class StatisticsSecondReducer :
    com.natifeuaandroid.coremodule.Reducer<StatisticsSecondState, StatisticsSecondEvent> {
    override fun reduce(
        state: StatisticsSecondState,
        event: StatisticsSecondEvent,
    ): StatisticsSecondState {
        return when (event) {
            is StatisticsSecondEvent.DataModelIsReceivedEvent -> state.copy(
                modelLines = event.modelLines,
                modelColumns = event.modelColumns
            )

            is StatisticsSecondEvent.ErrorEvent -> state
            is StatisticsSecondEvent.GetDataModelEvent -> state
        }
    }

    override fun createInitialState(): StatisticsSecondState {
        return StatisticsSecondState()
    }
}
