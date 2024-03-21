package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.UiEvent


sealed class StatisticsEvent : UiEvent {
    data object ErrorEvent : StatisticsEvent()
}