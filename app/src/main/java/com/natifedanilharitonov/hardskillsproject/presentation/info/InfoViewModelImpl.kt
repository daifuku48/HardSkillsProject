package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.info.InfoEvent
import com.natifedanilharitonov.domain.use_cases.info.InfoState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class InfoViewModelImpl(
    reducer: Reducer<InfoState, InfoEvent, InfoUiState>,
    useCases: Set<UseCase<InfoState, InfoEvent>>,
    navigator: Navigator,
) : BaseViewModel<InfoState, InfoEvent, InfoUiState>(reducer, useCases, navigator), InfoViewModel {

    init {
        handleEvent(InfoEvent.GetUserInfoEvent)
    }

    override fun createInitState(): InfoState = InfoState()

    override fun navigateToNextScreen() {

    }

    override fun getUserData() {
        handleEvent(InfoEvent.GetUserInfoEvent)
    }
}