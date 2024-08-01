package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstState

class RandomAnimeImageFirstViewModelImpl(
    reducer: Reducer<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent>,
    useCases: Set<UseCase<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent, RandomAnimeImageFirstUiState>(
    reducer,
    useCases,
    navigator,
),
    RandomAnimeImageFirstViewModel {
    init {
        handleEvent(RandomAnimeImageFirstEvent.GetRandomImageEvent)
    }

    override fun mapToUiModel(state: RandomAnimeImageFirstState): RandomAnimeImageFirstUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: RandomAnimeImageFirstEvent) {}

    override fun refreshImage() {
        handleEvent(RandomAnimeImageFirstEvent.GetRandomImageEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.RandomAnimeImageSecondScreen.route)
    }

    override fun popBackScreen() {
        popBack()
    }
}
