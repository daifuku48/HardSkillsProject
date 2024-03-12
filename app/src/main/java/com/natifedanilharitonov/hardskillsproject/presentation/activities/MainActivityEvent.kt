package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class MainActivityEvent : UiEvent {
    data object GetStartDestinationEvent : MainActivityEvent()
    data class StartDestinationIsReceivedEvent(val startDestination: String) : MainActivityEvent()
    data class SetSelectedNavigationBarItemEvent(val selectedItem: Int) : MainActivityEvent()
    data class ChangeBottomStateEvent(val bottomState: Boolean) : MainActivityEvent()
    data object ErrorEvent : MainActivityEvent()
}