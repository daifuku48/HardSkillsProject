package com.natifedanilharitonov.hardskillsproject.presentation.userList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.userList.components.UserListContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListView(viewModel: UserListViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    UserListContainer(
        userList = state.userList,
        addUsers = viewModel::addUsers,
        backToMain = viewModel::backToMain,
        pagingValue = state.canPaging,
        pagingState = state.pagingState,
    )
}