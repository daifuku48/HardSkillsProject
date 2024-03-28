package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class StatisticsFirstReducer : Reducer<StatisticsFirstState, StatisticsFirstEvent> {
    override fun reduce(
        state: StatisticsFirstState,
        event: StatisticsFirstEvent
    ): StatisticsFirstState {
        return when (event) {
            is StatisticsFirstEvent.ErrorEvent -> state
            is StatisticsFirstEvent.GetStatsModel -> state
            is StatisticsFirstEvent.StatsModelIsReceived -> state.copy(model = event.model)
        }
    }
}