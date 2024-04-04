package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.random_anime_image_first.RandomAnimeImageFirstEvent
import com.natifedanilharitonov.domain.features.random_anime_image_first.RandomAnimeImageFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class RandomAnimeImageFirstViewModelImpl(
    reducer: Reducer<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent, RandomAnimeImageFirstUiState>,
    useCases: Set<UseCase<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent>>,
    navigator: Navigator
) : BaseViewModel<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent, RandomAnimeImageFirstUiState>(
    reducer,
    useCases,
    navigator
), RandomAnimeImageFirstViewModel {
    init {
        handleEvent(RandomAnimeImageFirstEvent.GetRandomImageEvent)
    }

    override fun getAnimeImage() {
        handleEvent(RandomAnimeImageFirstEvent.GetRandomImageEvent)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.RandomAnimeImageSecondScreen.route)
    }

    override fun createInitState(): RandomAnimeImageFirstState =
        RandomAnimeImageFirstState()
}