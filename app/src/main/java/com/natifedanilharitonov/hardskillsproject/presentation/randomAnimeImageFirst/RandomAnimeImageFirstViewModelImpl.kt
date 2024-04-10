package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.randomAnimeImageFirst.RandomAnimeImageFirstEvent
import com.natifedanilharitonov.domain.features.randomAnimeImageFirst.RandomAnimeImageFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class RandomAnimeImageFirstViewModelImpl(
    reducer: Reducer<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent, RandomAnimeImageFirstUiState>,
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

    override fun refreshImage() {
        handleEvent(RandomAnimeImageFirstEvent.GetRandomImageEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.RandomAnimeImageSecondScreen.route)
    }

    override fun createInitState(): RandomAnimeImageFirstState = RandomAnimeImageFirstState()
}
