package com.natifedanilharitonov.hardskillsproject.presentation.userList


import com.natifedanilharitonov.hardskillsproject.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifeuaandroid.coremodule.Reducer
import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.userList.UserListEvent
import com.natifeuaandroid.domainmodule.features.userList.UserListState

class UserListViewModelImpl(
    reducer: Reducer<UserListState, UserListEvent>,
    useCases: Set<UseCase<UserListState, UserListEvent>>,
    navigator: Navigator,
) : BaseViewModel<UserListState, UserListEvent, UserListUiState>(reducer, useCases, navigator),
    UserListViewModel {
    init {
        handleEvent(UserListEvent.GetUsersEvent)
    }

    override fun mapToUiModel(state: UserListState): UserListUiState {
        return state.toUi()
    }

    override fun handleSpecialEvents(event: UserListEvent) {}

    override fun addUsers() {
        handleEvent(UserListEvent.PagingToEndEvent)
    }

    override fun backToMain() {
        navigate(Screen.RandomUserFirstScreen.route)
    }

    override fun popBackScreen() {
        popBack()
    }
}
