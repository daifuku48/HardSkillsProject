package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.random_anime_image.RandomAnimeImageEvent
import com.natifedanilharitonov.domain.use_cases.random_anime_image.RandomAnimeImageState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.RandomAnimeImageUiState

class RandomAnimeImageViewModelImpl(
    reducer: Reducer<RandomAnimeImageState, RandomAnimeImageEvent, RandomAnimeImageUiState>,
    useCases: Set<UseCase<RandomAnimeImageState, RandomAnimeImageEvent>>,
    navigator: Navigator
) : BaseViewModel<RandomAnimeImageState, RandomAnimeImageEvent, RandomAnimeImageUiState>(
    reducer,
    useCases,
    navigator
),
    RandomAnimeImageViewModel {
    init {
        handleEvent(RandomAnimeImageEvent.GetRandomImageEvent)
    }

    override fun createInitState(): RandomAnimeImageState =
        RandomAnimeImageState()

    override fun navigateToNextScreen() {

    }

    override fun refreshImage() {
        handleEvent(RandomAnimeImageEvent.GetRandomImageEvent)
    }
}