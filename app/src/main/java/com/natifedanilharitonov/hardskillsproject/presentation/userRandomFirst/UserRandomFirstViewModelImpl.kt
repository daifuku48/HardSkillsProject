package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.userRandomFirst.UserRandomFirstEvent
import com.natifedanilharitonov.domain.features.userRandomFirst.UserRandomFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserRandomFirstUiState

class UserRandomFirstViewModelImpl(
    reducer: Reducer<UserRandomFirstState, UserRandomFirstEvent, UserRandomFirstUiState>,
    useCases: Set<UseCase<UserRandomFirstState, UserRandomFirstEvent>>,
    navigator: Navigator,
) : BaseViewModel<UserRandomFirstState, UserRandomFirstEvent, UserRandomFirstUiState>(
        reducer,
        useCases,
        navigator,
    ),
    UserRandomFirstViewModel {
    init {
        handleEvent(UserRandomFirstEvent.GetRandomUserInfoEvent)
    }

    override fun createInitState(): UserRandomFirstState = UserRandomFirstState()

    override fun navigateToNextScreen() {
        navigate(Screen.RandomUserSecondScreen.route)
    }

    override fun popToMain() {
        popBackStack(Screen.MainScreen.route, false)
    }
}
