package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class MainActivityEvent : UiEvent {
    data object GetStartDestination : MainActivityEvent()
    data class StartDestinationIsReceived(val startDestination: String) : MainActivityEvent()
    data object ErrorEvent : MainActivityEvent()
}