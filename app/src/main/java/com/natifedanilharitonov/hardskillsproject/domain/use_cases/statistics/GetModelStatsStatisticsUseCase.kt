package com.natifedanilharitonov.hardskillsproject.domain.use_cases.statistics

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.RandomStatsRepository
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsEvent
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel

class GetModelStatsStatisticsUseCase(
    private val repository: RandomStatsRepository
) : UseCase<StatisticsState, StatisticsEvent> {
    override suspend fun execute(state: StatisticsState, event: StatisticsEvent): StatisticsEvent {
        return if (event is StatisticsEvent.GetModelStatsEvent) {
            val list = repository.getRandomStats()
            if (list != null) {
                StatisticsEvent.ModelStatsIsReceivedEvent(stats = StatModel.Model(list))
            } else StatisticsEvent.ModelStatsIsReceivedEvent(stats = StatModel.Error)
        } else StatisticsEvent.ErrorEvent
    }

    override fun canHandle(event: StatisticsEvent): Boolean {
        return event is StatisticsEvent.GetModelStatsEvent
    }
}