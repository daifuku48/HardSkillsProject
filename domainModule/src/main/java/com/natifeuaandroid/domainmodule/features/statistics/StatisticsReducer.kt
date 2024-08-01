package com.natifeuaandroid.domainmodule.features.statistics

import com.natifeuaandroid.coremodule.Reducer

class StatisticsReducer : Reducer<StatisticsState, StatisticsEvent> {
    override fun reduce(
        state: StatisticsState,
        event: StatisticsEvent,
    ): StatisticsState {
        return when (event) {
            is StatisticsEvent.ErrorEvent -> state
            is StatisticsEvent.GetModelStatsEvent -> state
            is StatisticsEvent.ModelStatsIsReceivedEvent -> state.copy(statModel = event.stats)
        }
    }

    override fun createInitialState(): StatisticsState {
        return StatisticsState()
    }
}
