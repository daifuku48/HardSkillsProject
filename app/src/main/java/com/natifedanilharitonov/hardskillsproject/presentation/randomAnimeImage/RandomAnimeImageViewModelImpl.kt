package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage


import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageState

class RandomAnimeImageViewModelImpl(
    reducer: Reducer<RandomAnimeImageState, RandomAnimeImageEvent>,
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

    override fun mapToUiModel(state: RandomAnimeImageState): RandomAnimeImageUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: RandomAnimeImageEvent) {}

    override fun navigateToNextScreen() {
        navigate(Screen.RandomAnimeImageFirstScreen.route)
    }

    override fun refreshImage() {
        handleEvent(RandomAnimeImageEvent.GetRandomImageEvent)
    }

    override fun popBackToMain() {
        popBackStack(Screen.MainScreen.route, false)
    }
}
