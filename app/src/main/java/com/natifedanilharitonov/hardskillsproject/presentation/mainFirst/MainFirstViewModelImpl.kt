package com.natifedanilharitonov.hardskillsproject.presentation.mainFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.mainFirst.MainFirstEvent
import com.natifedanilharitonov.domain.features.mainFirst.MainFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class MainFirstViewModelImpl(
    reducer: Reducer<MainFirstState, MainFirstEvent, MainFirstUiState>,
    useCases: Set<UseCase<MainFirstState, MainFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<MainFirstState, MainFirstEvent, MainFirstUiState>(reducer, useCases, navigator),
    MainFirstViewModel {
    init {
        handleEvent(MainFirstEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainFirstState = MainFirstState()

    override fun navigateToNextScreen() {
        navigate(Screen.MainSecondMockScreen.route)
    }
}
