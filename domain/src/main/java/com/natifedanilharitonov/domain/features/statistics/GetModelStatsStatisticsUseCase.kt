package com.natifedanilharitonov.domain.features.statistics

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.RandomStatsRepository

class GetModelStatsStatisticsUseCase(
    private val repository: RandomStatsRepository,
) : UseCase<StatisticsState, StatisticsEvent> {
    override suspend fun execute(
        state: StatisticsState,
        event: StatisticsEvent,
    ): StatisticsEvent {
        return if (event is StatisticsEvent.GetModelStatsEvent) {
            val list = repository.getRandomStats()
            if (list != null) {
                StatisticsEvent.ModelStatsIsReceivedEvent(stats = StatModel.Model(list))
            } else {
                StatisticsEvent.ModelStatsIsReceivedEvent(stats = StatModel.Error)
            }
        } else {
            StatisticsEvent.ErrorEvent
        }
    }

    override fun canHandle(event: StatisticsEvent): Boolean {
        return event is StatisticsEvent.GetModelStatsEvent
    }
}
