package com.natifedanilharitonov.hardskillsproject.presentation.userList

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.userList.UserListEvent
import com.natifedanilharitonov.domain.features.userList.UserListState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class UserListViewModelImpl(
    reducer: Reducer<UserListState, UserListEvent, UserListUiState>,
    useCases: Set<UseCase<UserListState, UserListEvent>>,
    navigator: Navigator,
) : BaseViewModel<UserListState, UserListEvent, UserListUiState>(reducer, useCases, navigator),
    UserListViewModel {
    init {
        handleEvent(UserListEvent.GetUsersEvent)
    }

    override fun createInitState(): UserListState = UserListState()

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
