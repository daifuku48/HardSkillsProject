package com.natifedanilharitonov.hardskillsproject.presentation.activities

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class MainActivityViewModelImpl(
    reducer: MainActivityReducer,
    useCases: Set<UseCase<MainActivityState, MainActivityEvent>>,
    navigator: Navigator
) : BaseViewModel<MainActivityState, MainActivityEvent>(reducer, useCases, navigator),
    MainActivityViewModel {
    init {
        handleEvent(MainActivityEvent.GetStartDestinationEvent)
    }

    override fun createInitState(): MainActivityState = MainActivityState()

    override fun navigateBottomBarMenu(route: String, index: Int) {
        handleEvent(MainActivityEvent.SetSelectedNavigationBarItemEvent(index))
        val navOptions = NavOptions
            .Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(
                saveState = true,
                route = route,
                inclusive = true
            )
            .build()
        navigate(route, navOptions)
    }

    override fun changeBottomState(bottomState: Boolean) {
        handleEvent(MainActivityEvent.ChangeBottomStateEvent(bottomState))
    }

    override fun navigateDrawerMenu(route: String) {
        navigate(route)
    }

    fun changeDrawerState(drawerState: Boolean) {
        handleEvent(MainActivityEvent.ChangeDrawerStateEvent(drawerState))
    }
}