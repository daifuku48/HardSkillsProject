package com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondEvent
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondState

class UserRandomSecondViewModelImpl(
    reducer: Reducer<UserRandomSecondState, UserRandomSecondEvent>,
    useCases: Set<UseCase<UserRandomSecondState, UserRandomSecondEvent>>,
    navigator: Navigator,
) : BaseViewModel<UserRandomSecondState, UserRandomSecondEvent, UserRandomSecondUiState>(
    reducer,
    useCases,
    navigator,
),
    UserRandomSecondViewModel {
    init {
        handleEvent(UserRandomSecondEvent.GetRandomUserInfo)
    }

    override fun navigateToNextScreen() {
        navigate(Screen.UsersScreen.route)
    }

    override fun popBackScreen() {
        popBack()
    }

    override fun mapToUiModel(state: UserRandomSecondState): UserRandomSecondUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: UserRandomSecondEvent) {}
}
