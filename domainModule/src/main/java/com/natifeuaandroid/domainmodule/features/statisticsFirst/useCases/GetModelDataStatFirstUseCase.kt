package com.natifeuaandroid.domainmodule.features.statisticsFirst.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstEvent
import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstState
import com.natifeuaandroid.domainmodule.repository.RandomStatsRepository

class GetModelDataStatFirstUseCase(
    private val repository: RandomStatsRepository,
) : UseCase<StatisticsFirstState, StatisticsFirstEvent> {
    override suspend fun execute(
        state: StatisticsFirstState,
        event: StatisticsFirstEvent,
    ): StatisticsFirstEvent {
        return if (event is StatisticsFirstEvent.GetStatsModel) {
            val list = repository.getRandomStats()
            StatisticsFirstEvent.StatsModelIsReceived(model = list)
        } else {
            StatisticsFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: StatisticsFirstEvent): Boolean {
        return event is StatisticsFirstEvent.GetStatsModel
    }
}
