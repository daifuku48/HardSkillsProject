package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class MainFirstViewModelImpl(
    reducer: Reducer<MainFirstState, MainFirstEvent>,
    useCases: Set<UseCase<MainFirstState, MainFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<MainFirstState, MainFirstEvent>(reducer, useCases, navigator),
    MainFirstViewModel {

    init {
        handleEvent(MainFirstEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainFirstState = MainFirstState()

    override fun navigateToNextScreen() {
        navigate(Screen.MainSecondMockScreen.route)
    }
}