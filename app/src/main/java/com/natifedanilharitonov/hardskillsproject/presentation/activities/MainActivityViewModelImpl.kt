package com.natifedanilharitonov.hardskillsproject.presentation.activities

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.mainActivity.MainActivityEvent
import com.natifeuaandroid.domainmodule.features.mainActivity.MainActivityState

class MainActivityViewModelImpl(
    reducer: Reducer<MainActivityState, MainActivityEvent>,
    useCases: Set<UseCase<MainActivityState, MainActivityEvent>>,
    navigator: Navigator,
) : BaseViewModel<MainActivityState, MainActivityEvent, MainActivityUiState>(
    reducer,
    useCases,
    navigator,
),
    MainActivityViewModel {
    init {
        handleEvent(MainActivityEvent.GetStartDestinationEvent)
    }

    override fun mapToUiModel(state: MainActivityState): MainActivityUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: MainActivityEvent) {}

    override fun navigateBottomBarMenu(
        route: String,
        index: Int,
    ) {
        handleEvent(MainActivityEvent.SetSelectedNavigationBarItemEvent(index))
        val navOptions =
            NavOptions
                .Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(
                    route = route,
                    inclusive = true,
                ).build()
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
