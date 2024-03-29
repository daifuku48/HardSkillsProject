package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.main_first.MainFirstEvent
import com.natifedanilharitonov.domain.use_cases.main_first.MainFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class MainFirstViewModelImpl(
    reducer: Reducer<MainFirstState, MainFirstEvent, MainFirstUiState>,
    useCases: Set<UseCase<MainFirstState, MainFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<MainFirstState, MainFirstEvent, MainFirstUiState>(reducer, useCases, navigator),
    MainFirstViewModel {

    init {
        handleEvent(MainFirstEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainFirstState =
        MainFirstState()

    override fun navigateToNextScreen() {
        navigate(Screen.MainSecondMockScreen.route)
    }
}