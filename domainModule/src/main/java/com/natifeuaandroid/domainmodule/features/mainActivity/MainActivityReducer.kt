package com.natifeuaandroid.domainmodule.features.mainActivity

import com.natifeuaandroid.coremodule.Reducer


class MainActivityReducer : Reducer<MainActivityState, MainActivityEvent> {
    override fun reduce(
        state: MainActivityState,
        event: MainActivityEvent,
    ): MainActivityState =
        when (event) {
            is MainActivityEvent.ErrorEvent -> state
            is MainActivityEvent.GetStartDestinationEvent -> state
            is MainActivityEvent.SetSelectedNavigationBarItemEvent ->
                state.copy(
                    bottomNavigationSelectedItem = event.selectedItem,
                )

            is MainActivityEvent.StartDestinationIsReceivedEvent ->
                state.copy(
                    startDestination = event.startDestination,
                )

            is MainActivityEvent.ChangeBottomStateEvent -> state.copy(bottomState = event.bottomState)
            is MainActivityEvent.ChangeDrawerStateEvent -> state.copy(drawerState = event.drawerState)
        }

    override fun createInitialState(): MainActivityState {
        return MainActivityState()
    }
}
