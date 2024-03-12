package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class MainActivityReducer : Reducer<MainActivityState, MainActivityEvent> {
    override fun reduce(state: MainActivityState, event: MainActivityEvent): MainActivityState {
        return when (event) {
            is MainActivityEvent.ErrorEvent -> state
            is MainActivityEvent.GetStartDestinationEvent -> state
            is MainActivityEvent.SetSelectedNavigationBarItemEvent -> state.copy(
                bottomNavigationSelectedItem = event.selectedItem
            )

            is MainActivityEvent.StartDestinationIsReceivedEvent -> state.copy(
                startDestination = event.startDestination
            )

            is MainActivityEvent.ChangeBottomStateEvent -> state.copy(bottomState = event.bottomState)
        }
    }
}