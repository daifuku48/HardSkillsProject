package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.use_cases.user_list.UserListEvent
import com.natifedanilharitonov.domain.use_cases.user_list.UserListState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class UserListViewModelImpl(
    reducer: Reducer<UserListState, UserListEvent, UserListUiState>,
    useCases: Set<UseCase<UserListState, UserListEvent>>,
    navigator: Navigator
) : BaseViewModel<UserListState, UserListEvent, UserListUiState>(reducer, useCases, navigator),
    UserListViewModel {
    init {
        handleEvent(UserListEvent.GetUsersEvent)
    }

    override fun createInitState(): UserListState =
        UserListState()

    override fun addUsers() {
        handleEvent(UserListEvent.PagingToEndEvent)
    }

    override fun navigateToUser() {

    }
}