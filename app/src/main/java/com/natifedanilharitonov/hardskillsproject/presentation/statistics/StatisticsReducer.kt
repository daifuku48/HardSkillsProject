package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.statistics.StatModel
import com.natifedanilharitonov.domain.features.statistics.StatisticsEvent
import com.natifedanilharitonov.domain.features.statistics.StatisticsState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel

class StatisticsReducer(
    private val mapper: StatModel.Mapper<StatUiModel>
) : Reducer<StatisticsState, StatisticsEvent, StatisticsUiState> {
    override fun reduce(state: StatisticsState, event: StatisticsEvent): StatisticsState {
        return when (event) {
            is StatisticsEvent.ErrorEvent -> state
            is StatisticsEvent.GetModelStatsEvent -> state
            is StatisticsEvent.ModelStatsIsReceivedEvent -> state.copy(statModel = event.stats)
        }
    }

    override fun mapToUiModel(state: StatisticsState): StatisticsUiState {
        return StatisticsUiState(
            statModel = state.statModel.map(mapper)
        )
    }
}