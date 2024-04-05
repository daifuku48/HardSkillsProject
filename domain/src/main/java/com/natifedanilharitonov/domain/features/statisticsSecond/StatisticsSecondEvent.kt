package com.natifedanilharitonov.domain.features.statisticsSecond

import com.natifedanilharitonov.core.UiEvent

sealed class StatisticsSecondEvent : UiEvent {
    data object GetDataModelEvent : StatisticsSecondEvent()

    data class DataModelIsReceivedEvent(val model: DoubleStatModel) : StatisticsSecondEvent()

    data object ErrorEvent : StatisticsSecondEvent()
}
