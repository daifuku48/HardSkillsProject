package com.natifeuaandroid.domainmodule.features.statisticsFirst

import com.natifeuaandroid.coremodule.Reducer

class StatisticsFirstReducer :
    Reducer<StatisticsFirstState, StatisticsFirstEvent> {
    override fun reduce(
        state: StatisticsFirstState,
        event: StatisticsFirstEvent,
    ): StatisticsFirstState {
        return when (event) {
            is StatisticsFirstEvent.ErrorEvent -> state
            is StatisticsFirstEvent.GetStatsModel -> state
            is StatisticsFirstEvent.StatsModelIsReceived -> state.copy(model = event.model)
        }
    }

    override fun createInitialState(): StatisticsFirstState {
        return StatisticsFirstState()
    }
}
