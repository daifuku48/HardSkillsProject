package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.components.UserListContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListView(viewModel: UserListViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    UserListContainer(userList = state.userList)
}