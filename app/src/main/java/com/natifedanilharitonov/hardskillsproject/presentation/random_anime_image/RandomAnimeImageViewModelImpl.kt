package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class RandomAnimeImageViewModelImpl(
    reducer: Reducer<RandomAnimeImageState, RandomAnimeImageEvent>,
    useCases: Set<UseCase<RandomAnimeImageState, RandomAnimeImageEvent>>,
    navigator: Navigator
) : BaseViewModel<RandomAnimeImageState, RandomAnimeImageEvent>(reducer, useCases, navigator),
    RandomAnimeImageViewModel {
    override fun createInitState(): RandomAnimeImageState = RandomAnimeImageState()
}