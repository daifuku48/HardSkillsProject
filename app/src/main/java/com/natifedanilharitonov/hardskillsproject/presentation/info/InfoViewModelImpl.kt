package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class InfoViewModelImpl(
    reducer: Reducer<InfoState, InfoEvent>,
    useCases: Set<UseCase<InfoState, InfoEvent>>,
    navigator: Navigator
) : BaseViewModel<InfoState, InfoEvent>(reducer, useCases, navigator), InfoViewModel {

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