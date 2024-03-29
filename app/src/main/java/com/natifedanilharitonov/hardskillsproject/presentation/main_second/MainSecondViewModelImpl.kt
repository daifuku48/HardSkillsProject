package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.main_second.MainSecondEvent
import com.natifedanilharitonov.domain.use_cases.main_second.MainSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class MainSecondViewModelImpl(
    reducer: Reducer<MainSecondState, MainSecondEvent, MainSecondUiState>,
    useCases: Set<UseCase<MainSecondState, MainSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<MainSecondState, MainSecondEvent, MainSecondUiState>(
    reducer,
    useCases,
    navigator
),
    MainSecondViewModel {

    init {
        handleEvent(MainSecondEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainSecondState =
        MainSecondState()

    override fun backToMain() {
        popBack()
    }
}