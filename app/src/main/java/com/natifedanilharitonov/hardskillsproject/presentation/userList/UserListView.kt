package com.natifedanilharitonov.hardskillsproject.presentation.userList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
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
        popBackText = stringResource(id = R.string.back),
        popBack = viewModel::popBackScreen,
        backToMainText = stringResource(id = R.string.back_to_main),
    )
}
