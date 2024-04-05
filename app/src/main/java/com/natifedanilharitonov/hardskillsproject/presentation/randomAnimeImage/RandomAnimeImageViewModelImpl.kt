package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.randomAnimeImage.RandomAnimeImageEvent
import com.natifedanilharitonov.domain.features.randomAnimeImage.RandomAnimeImageState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class RandomAnimeImageViewModelImpl(
    reducer: Reducer<RandomAnimeImageState, RandomAnimeImageEvent, RandomAnimeImageUiState>,
    useCases: Set<UseCase<RandomAnimeImageState, RandomAnimeImageEvent>>,
    navigator: Navigator,
) : BaseViewModel<RandomAnimeImageState, RandomAnimeImageEvent, RandomAnimeImageUiState>(
        reducer,
        useCases,
        navigator,
    ),
    RandomAnimeImageViewModel {
    init {
        handleEvent(RandomAnimeImageEvent.GetRandomImageEvent)
    }

    override fun createInitState(): RandomAnimeImageState = RandomAnimeImageState()

    override fun navigateToNextScreen() {
        navigate(Screen.RandomAnimeImageFirstScreen.route)
    }

    override fun refreshImage() {
        handleEvent(RandomAnimeImageEvent.GetRandomImageEvent)
    }
}
