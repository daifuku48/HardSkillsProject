package com.natifedanilharitonov.hardskillsproject.presentation.infoFirst


import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstEvent
import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstState

class InfoFirstViewModelImpl(
    reducer: com.natifeuaandroid.coremodule.Reducer<InfoFirstState, InfoFirstEvent>,
    useCases: Set<com.natifeuaandroid.coremodule.UseCase<InfoFirstState, InfoFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<InfoFirstState, InfoFirstEvent, InfoFirstUiState>(reducer, useCases, navigator),
    InfoFirstViewModel {
    init {
        handleEvent(InfoFirstEvent.GetTextEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.InfoSecondScreen.route)
    }

    override fun mapToUiModel(state: InfoFirstState): InfoFirstUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: InfoFirstEvent) {}
}
