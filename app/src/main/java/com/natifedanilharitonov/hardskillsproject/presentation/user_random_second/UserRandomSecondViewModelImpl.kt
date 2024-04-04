package com.natifedanilharitonov.hardskillsproject.presentation.user_random_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.user_random_second.UserRandomSecondEvent
import com.natifedanilharitonov.domain.features.user_random_second.UserRandomSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class UserRandomSecondViewModelImpl(
    reducer: Reducer<UserRandomSecondState, UserRandomSecondEvent, UserRandomSecondUiState>,
    useCases: Set<UseCase<UserRandomSecondState, UserRandomSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<UserRandomSecondState, UserRandomSecondEvent, UserRandomSecondUiState>(
    reducer,
    useCases,
    navigator
), UserRandomSecondViewModel {
    init {
        handleEvent(UserRandomSecondEvent.GetRandomUserInfo)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.UsersScreen.route)
    }

    override fun createInitState(): UserRandomSecondState = UserRandomSecondState()
}