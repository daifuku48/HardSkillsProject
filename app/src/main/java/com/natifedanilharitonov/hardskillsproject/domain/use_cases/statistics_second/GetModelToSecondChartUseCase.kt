package com.natifedanilharitonov.hardskillsproject.domain.use_cases.statistics_second

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.RandomStatsRepository
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.StatisticsSecondEvent
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.StatisticsSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components.DoubleStatModel

class GetModelToSecondChartUseCase(
    private val repository: RandomStatsRepository
) : UseCase<StatisticsSecondState, StatisticsSecondEvent> {
    override suspend fun execute(
        state: StatisticsSecondState,
        event: StatisticsSecondEvent
    ): StatisticsSecondEvent {
        return if (event is StatisticsSecondEvent.GetDataModelEvent) {
            val lineList = repository.getRandomStats()
            val columnList = repository.getRandomStats()
            if (lineList != null && columnList != null) {
                StatisticsSecondEvent.DataModelIsReceivedEvent(
                    model = DoubleStatModel.Model(
                        modelLines = lineList,
                        modelColumns = columnList
                    )
                )
            } else if (state.model is DoubleStatModel.Model) {
                StatisticsSecondEvent.ErrorEvent
            } else {
                StatisticsSecondEvent.DataModelIsReceivedEvent(model = DoubleStatModel.Error)
            }
        } else StatisticsSecondEvent.ErrorEvent
    }

    override fun canHandle(event: StatisticsSecondEvent): Boolean {
        return event is StatisticsSecondEvent.GetDataModelEvent
    }
}