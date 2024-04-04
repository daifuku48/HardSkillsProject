package com.natifedanilharitonov.hardskillsproject.presentation.info_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.info_first.InfoFirstEvent
import com.natifedanilharitonov.domain.features.info_first.InfoFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class InfoFirstViewModelImpl(
    reducer: Reducer<InfoFirstState, InfoFirstEvent, InfoFirstUiModel>,
    useCases: Set<UseCase<InfoFirstState, InfoFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<InfoFirstState, InfoFirstEvent, InfoFirstUiModel>(reducer, useCases, navigator),
    InfoFirstViewModel {
    init {
        handleEvent(InfoFirstEvent.GetTextEvent)
    }

    override fun createInitState(): InfoFirstState = InfoFirstState()
    override fun navigateToNextScreen() {
        navigate(Screen.InfoSecondScreen.route)
    }
}