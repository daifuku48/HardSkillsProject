package com.natifeuaandroid.domainmodule.features.mainActivity

sealed class MainActivityEvent {
    data object GetStartDestinationEvent : MainActivityEvent()

    data class StartDestinationIsReceivedEvent(
        val startDestination: String,
    ) : MainActivityEvent()

    data class SetSelectedNavigationBarItemEvent(
        val selectedItem: Int,
    ) : MainActivityEvent()

    data class ChangeBottomStateEvent(
        val bottomState: Boolean,
    ) : MainActivityEvent()

    data class ChangeDrawerStateEvent(
        val drawerState: Boolean,
    ) : MainActivityEvent()

    data object ErrorEvent : MainActivityEvent()
}
