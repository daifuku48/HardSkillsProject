package com.natifedanilharitonov.hardskillsproject.presentation.info


import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.info.InfoEvent
import com.natifeuaandroid.domainmodule.features.info.InfoState

class InfoViewModelImpl(
    reducer: Reducer<InfoState, InfoEvent>,
    useCases: Set<UseCase<InfoState, InfoEvent>>,
    navigator: Navigator,
) : BaseViewModel<InfoState, InfoEvent, InfoUiState>(reducer, useCases, navigator),
    InfoViewModel {
    init {
        handleEvent(InfoEvent.GetUserInfoEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.InfoFirstScreen.route)
    }

    override fun getUserData() {
        handleEvent(InfoEvent.GetUserInfoEvent)
    }

    override fun mapToUiModel(state: InfoState): InfoUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: InfoEvent) {}
}
