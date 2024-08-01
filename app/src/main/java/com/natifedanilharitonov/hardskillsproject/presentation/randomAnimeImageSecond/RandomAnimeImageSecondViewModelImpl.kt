package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondState

class RandomAnimeImageSecondViewModelImpl(
    reducer: Reducer<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent>,
    useCases: Set<UseCase<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent>>,
    navigator: Navigator,
) : BaseViewModel<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent, RandomAnimeImageSecondUiState>(
    reducer,
    useCases,
    navigator,
),
    RandomAnimeImageSecondViewModel {
    init {
        handleEvent(RandomAnimeImageSecondEvent.GetRandomImageEvent)
    }

    override fun popBackToMain() {
        navigate(Screen.RandomAnimeImageScreen.route)
    }

    override fun refreshImage() {
        handleEvent(RandomAnimeImageSecondEvent.GetRandomImageEvent)
    }

    override fun popBackToScreen() {
        popBack()
    }

    override fun mapToUiModel(state: RandomAnimeImageSecondState): RandomAnimeImageSecondUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: RandomAnimeImageSecondEvent) {}
}
