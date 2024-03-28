package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components.DoubleStatModel

sealed class StatisticsSecondEvent : UiEvent {
    data object GetDataModelEvent : StatisticsSecondEvent()
    data class DataModelIsReceivedEvent(val model: DoubleStatModel) : StatisticsSecondEvent()
    data object ErrorEvent : StatisticsSecondEvent()
}