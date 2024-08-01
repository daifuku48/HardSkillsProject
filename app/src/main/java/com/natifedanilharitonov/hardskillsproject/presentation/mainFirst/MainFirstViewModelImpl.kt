package com.natifedanilharitonov.hardskillsproject.presentation.mainFirst

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.mainFirst.MainFirstEvent
import com.natifeuaandroid.domainmodule.features.mainFirst.MainFirstState

class MainFirstViewModelImpl(
    reducer: Reducer<MainFirstState, MainFirstEvent>,
    useCases: Set<UseCase<MainFirstState, MainFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<MainFirstState, MainFirstEvent, MainFirstUiState>(reducer, useCases, navigator),
    MainFirstViewModel {
    init {
        handleEvent(MainFirstEvent.GetMainTextEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.MainSecondMockScreen.route)
    }

    override fun mapToUiModel(state: MainFirstState): MainFirstUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: MainFirstEvent) {}
}
