package com.natifedanilharitonov.domain.features.statisticsFirst

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.statistics.StatModel
import com.natifedanilharitonov.domain.repository.RandomStatsRepository

class GetModelDataStatFirstUseCase(
    private val repository: RandomStatsRepository,
) : UseCase<StatisticsFirstState, StatisticsFirstEvent> {
    override suspend fun execute(
        state: StatisticsFirstState,
        event: StatisticsFirstEvent,
    ): StatisticsFirstEvent {
        return if (event is StatisticsFirstEvent.GetStatsModel) {
            val list = repository.getRandomStats()
            if (list != null) {
                StatisticsFirstEvent.StatsModelIsReceived(model = StatModel.Model(list))
            } else if (state.model !is StatModel.Pending) {
                StatisticsFirstEvent.ErrorEvent
            } else {
                StatisticsFirstEvent.StatsModelIsReceived(model = StatModel.Error)
            }
        } else {
            StatisticsFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: StatisticsFirstEvent): Boolean {
        return event is StatisticsFirstEvent.GetStatsModel
    }
}
