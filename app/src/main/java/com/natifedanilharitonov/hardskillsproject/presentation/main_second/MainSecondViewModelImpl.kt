package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class MainSecondViewModelImpl(
    reducer: Reducer<MainSecondState, MainSecondEvent>,
    useCases: Set<UseCase<MainSecondState, MainSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<MainSecondState, MainSecondEvent>(reducer, useCases, navigator),
    MainSecondViewModel {

    init {
        handleEvent(MainSecondEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainSecondState = MainSecondState()

    override fun backToMain() {
        popBack()
    }
}