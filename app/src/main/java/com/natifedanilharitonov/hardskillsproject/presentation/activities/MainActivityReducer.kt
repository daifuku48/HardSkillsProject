package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.main_activity.StartDestinationResult
import com.natifedanilharitonov.domain.features.main_activity.MainActivityState
import com.natifedanilharitonov.domain.features.main_activity.MainActivityEvent
import com.natifedanilharitonov.hardskillsproject.presentation.activities.model.StartDestinationUiModel

class MainActivityReducer(
    private val mapper: StartDestinationResult.Mapper<StartDestinationUiModel>
) : Reducer<MainActivityState, MainActivityEvent, MainActivityUiState> {
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
            is MainActivityEvent.ChangeDrawerStateEvent -> state.copy(drawerState = event.drawerState)
        }
    }

    override fun mapToUiModel(state: MainActivityState): MainActivityUiState {
        return MainActivityUiState(
            bottomState = state.bottomState,
            drawerState = state.drawerState,
            startDestination = state.startDestination?.map(mapper),
            bottomNavigationSelectedItem = state.bottomNavigationSelectedItem
        )
    }
}