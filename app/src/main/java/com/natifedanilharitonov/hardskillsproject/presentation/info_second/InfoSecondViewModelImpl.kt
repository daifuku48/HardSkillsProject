package com.natifedanilharitonov.hardskillsproject.presentation.info_second

import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.info_second.InfoSecondEvent
import com.natifedanilharitonov.domain.features.info_second.InfoSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class InfoSecondViewModelImpl(
    reducer: Reducer<InfoSecondState, InfoSecondEvent, InfoSecondUiModel>,
    useCases: Set<UseCase<InfoSecondState, InfoSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<InfoSecondState, InfoSecondEvent, InfoSecondUiModel>(
    reducer,
    useCases,
    navigator
), InfoSecondViewModel {

    init {
        handleEvent(InfoSecondEvent.GetTextEvent)
    }

    override fun createInitState(): InfoSecondState = InfoSecondState()
    override fun backToMain() {
        val navOptions = NavOptions.Builder().setLaunchSingleTop(true)
            .setPopUpTo(Screen.InfoScreen.route, true)
            .setPopUpTo(Screen.InfoSecondScreen.route, true)
            .setPopUpTo(Screen.InfoFirstScreen.route, true).build()
        navigate(Screen.InfoScreen.route, navOptions)
    }
}