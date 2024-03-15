package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator

class UserListViewModelImpl(
    reducer: Reducer<UserListState, UserListEvent>,
    useCases: Set<UseCase<UserListState, UserListEvent>>,
    navigator: Navigator
) : BaseViewModel<UserListState, UserListEvent>(reducer, useCases, navigator), UserListViewModel {
    init {
        handleEvent(UserListEvent.GetUsersEvent)
    }

    override fun createInitState(): UserListState = UserListState()
    override fun addUsers() {
        handleEvent(UserListEvent.PagingToEndEvent)
    }

    override fun navigateToUser() {

    }
}