package com.natifeuaandroid.domainmodule.features.statistics.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.statistics.StatisticsEvent
import com.natifeuaandroid.domainmodule.features.statistics.StatisticsState
import com.natifeuaandroid.domainmodule.repository.RandomStatsRepository


class GetModelStatsStatisticsUseCase(
    private val repository: RandomStatsRepository,
) : UseCase<StatisticsState, StatisticsEvent> {
    override suspend fun execute(
        state: StatisticsState,
        event: StatisticsEvent,
    ): StatisticsEvent {
        return if (event is StatisticsEvent.GetModelStatsEvent) {
            val list = repository.getRandomStats()
            StatisticsEvent.ModelStatsIsReceivedEvent(list)
        } else {
            StatisticsEvent.ErrorEvent
        }
    }

    override fun canHandle(event: StatisticsEvent): Boolean {
        return event is StatisticsEvent.GetModelStatsEvent
    }
}
