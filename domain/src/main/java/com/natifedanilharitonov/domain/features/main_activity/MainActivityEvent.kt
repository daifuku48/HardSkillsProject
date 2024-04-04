package com.natifedanilharitonov.domain.features.main_activity

import com.natifedanilharitonov.core.UiEvent

sealed class MainActivityEvent : UiEvent {
    data object GetStartDestinationEvent : MainActivityEvent()
    data class StartDestinationIsReceivedEvent(val startDestination: StartDestinationResult) : MainActivityEvent()
    data class SetSelectedNavigationBarItemEvent(val selectedItem: Int) : MainActivityEvent()
    data class ChangeBottomStateEvent(val bottomState: Boolean) : MainActivityEvent()
    data class ChangeDrawerStateEvent(val drawerState: Boolean) : MainActivityEvent()
    data object ErrorEvent : MainActivityEvent()
}