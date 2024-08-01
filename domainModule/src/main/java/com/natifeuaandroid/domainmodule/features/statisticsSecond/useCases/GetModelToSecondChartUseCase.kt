package com.natifeuaandroid.domainmodule.features.statisticsSecond.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondEvent
import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondState
import com.natifeuaandroid.domainmodule.repository.RandomStatsRepository


class GetModelToSecondChartUseCase(
    private val repository: RandomStatsRepository,
) : UseCase<StatisticsSecondState, StatisticsSecondEvent> {
    override suspend fun execute(
        state: StatisticsSecondState,
        event: StatisticsSecondEvent,
    ): StatisticsSecondEvent {
        return if (event is StatisticsSecondEvent.GetDataModelEvent) {
            val lineList = repository.getRandomStats()
            val columnList = repository.getRandomStats()
            StatisticsSecondEvent.DataModelIsReceivedEvent(
                modelLines = lineList,
                modelColumns = columnList,
            )
        } else {
            StatisticsSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: StatisticsSecondEvent): Boolean {
        return event is StatisticsSecondEvent.GetDataModelEvent
    }
}
