package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.random_anime_image_second.RandomAnimeImageSecondEvent
import com.natifedanilharitonov.domain.features.random_anime_image_second.RandomAnimeImageSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class RandomAnimeImageSecondViewModelImpl(
    reducer: Reducer<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent, RandomAnimeImageSecondUiState>,
    useCases: Set<UseCase<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent, RandomAnimeImageSecondUiState>(
    reducer,
    useCases,
    navigator
),
    RandomAnimeImageSecondViewModel {
    init {
        handleEvent(RandomAnimeImageSecondEvent.GetRandomImageEvent)
    }

    override fun popBackToMain() {
        navigate(Screen.RandomAnimeImageScreen.route)
    }

    override fun getAnimeImage() {
        handleEvent(RandomAnimeImageSecondEvent.GetRandomImageEvent)
    }

    override fun createInitState(): RandomAnimeImageSecondState =
        RandomAnimeImageSecondState()
}