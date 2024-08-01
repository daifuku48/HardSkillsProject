package com.natifedanilharitonov.hardskillsproject.presentation.infoSecond

import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.infoSecond.InfoSecondEvent
import com.natifeuaandroid.domainmodule.features.infoSecond.InfoSecondState

class InfoSecondViewModelImpl(
    reducer: Reducer<InfoSecondState, InfoSecondEvent>,
    useCases: Set<UseCase<InfoSecondState, InfoSecondEvent>>,
    navigator: Navigator,
) : BaseViewModel<InfoSecondState, InfoSecondEvent, InfoSecondUiState>(
    reducer,
    useCases,
    navigator,
),
    InfoSecondViewModel {
    init {
        handleEvent(InfoSecondEvent.GetTextEvent)
    }

    override fun backToMain() {
        val navOptions =
            NavOptions
                .Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(Screen.InfoScreen.route, true)
                .setPopUpTo(Screen.InfoSecondScreen.route, true)
                .setPopUpTo(Screen.InfoFirstScreen.route, true)
                .build()
        navigate(Screen.InfoScreen.route, navOptions)
    }

    override fun mapToUiModel(state: InfoSecondState): InfoSecondUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: InfoSecondEvent) {}
}
