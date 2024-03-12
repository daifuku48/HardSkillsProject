package com.natifedanilharitonov.hardskillsproject.presentation.activities

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class MainActivityViewModel(
    reducer: MainActivityReducer,
    useCases: Set<UseCase<MainActivityState, MainActivityEvent>>,
    navigator: Navigator
) : BaseViewModel<MainActivityState, MainActivityEvent>(reducer, useCases, navigator) {
    init {
        handleEvent(MainActivityEvent.GetStartDestinationEvent)
    }
    override fun createInitState(): MainActivityState = MainActivityState()

    override fun handleCaughtEvent(event: MainActivityEvent) {}

    fun navigateBottomBarMenu(route: String, index: Int) {
        handleEvent(MainActivityEvent.SetSelectedNavigationBarItemEvent(index))
        val navOptions = NavOptions.Builder().setLaunchSingleTop(true)
            .setPopUpTo(saveState = true, route = route, inclusive = true).setRestoreState(true)
            .build()
        navigate(route, navOptions)
    }

    fun changeBottomState(bottomState: Boolean) {
        handleEvent(MainActivityEvent.ChangeBottomStateEvent(bottomState))
    }
}