package com.natifedanilharitonov.hardskillsproject.presentation.mainSecond

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.mainSecond.MainSecondEvent
import com.natifeuaandroid.domainmodule.features.mainSecond.MainSecondState

class MainSecondViewModelImpl(
    reducer: Reducer<MainSecondState, MainSecondEvent>,
    useCases: Set<UseCase<MainSecondState, MainSecondEvent>>,
    navigator: Navigator,
) : BaseViewModel<MainSecondState, MainSecondEvent, MainSecondUiState>(
    reducer,
    useCases,
    navigator,
),
    MainSecondViewModel {
    init {
        handleEvent(MainSecondEvent.GetMainTextEvent)
    }


    override fun mapToUiModel(state: MainSecondState): MainSecondUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: MainSecondEvent) {}

    override fun backToMain() {
        val navOptions =
            NavOptions
                .Builder()
                .setPopUpTo(
                    route = Screen.MainSecondMockScreen.route,
                    inclusive = true,
                ).build()
        navigate(Screen.MainScreen.route, navOptions)
    }
}
