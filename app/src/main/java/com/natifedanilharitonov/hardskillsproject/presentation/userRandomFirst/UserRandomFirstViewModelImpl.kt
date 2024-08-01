package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst

import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstEvent
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstState

class UserRandomFirstViewModelImpl(
    reducer: Reducer<UserRandomFirstState, UserRandomFirstEvent>,
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

    override fun navigateToNextScreen() {
        navigate(Screen.RandomUserSecondScreen.route)
    }

    override fun popToMain() {
        popBackStack(Screen.MainScreen.route, false)
    }

    override fun mapToUiModel(state: UserRandomFirstState): UserRandomFirstUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: UserRandomFirstEvent) {}
}
