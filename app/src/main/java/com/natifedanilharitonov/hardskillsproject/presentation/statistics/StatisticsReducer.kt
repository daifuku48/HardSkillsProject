package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class StatisticsReducer : Reducer<StatisticsState, StatisticsEvent> {
    override fun reduce(state: StatisticsState, event: StatisticsEvent): StatisticsState {
        return when (event) {
            is StatisticsEvent.ErrorEvent -> state
        }
    }
}