package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.statistics_second.DoubleStatModel
import com.natifedanilharitonov.domain.features.statistics_second.StatisticsSecondEvent
import com.natifedanilharitonov.domain.features.statistics_second.StatisticsSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model.DoubleStatUiModel

class StatisticsSecondReducer(
    private val mapper: DoubleStatModel.Mapper<DoubleStatUiModel>
) : Reducer<StatisticsSecondState, StatisticsSecondEvent, StatisticsSecondUiState> {
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

    override fun mapToUiModel(state: StatisticsSecondState): StatisticsSecondUiState {
        return StatisticsSecondUiState(
            model = state.model.map(mapper)
        )
    }
}