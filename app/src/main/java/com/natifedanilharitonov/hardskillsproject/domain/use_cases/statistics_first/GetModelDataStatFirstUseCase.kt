package com.natifedanilharitonov.hardskillsproject.domain.use_cases.statistics_first

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.RandomStatsRepository
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.StatisticsFirstEvent
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.StatisticsFirstState

class GetModelDataStatFirstUseCase(
    private val repository: RandomStatsRepository
) : UseCase<StatisticsFirstState, StatisticsFirstEvent> {
    override suspend fun execute(
        state: StatisticsFirstState,
        event: StatisticsFirstEvent
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
        } else StatisticsFirstEvent.ErrorEvent
    }

    override fun canHandle(event: StatisticsFirstEvent): Boolean {
        return event is StatisticsFirstEvent.GetStatsModel
    }
}