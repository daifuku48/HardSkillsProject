package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.statistics.StatModel
import com.natifedanilharitonov.domain.use_cases.statistics_first.StatisticsFirstEvent
import com.natifedanilharitonov.domain.use_cases.statistics_first.StatisticsFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel

class StatisticsFirstReducer(
    private val statsMapper: StatModel.Mapper<StatUiModel>
) :
    Reducer<StatisticsFirstState, StatisticsFirstEvent, StatisticsFirstUiState> {
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

    override fun mapToUiModel(state: StatisticsFirstState): StatisticsFirstUiState {
        return StatisticsFirstUiState(
            model = state.model.map(statsMapper)
        )
    }
}