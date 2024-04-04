package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.components.UserInfoContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserRandomFirstView(viewModel: UserRandomFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    UserInfoContainer(userResult = state.userResult, onNextScreen = viewModel::navigateToNextScreen)
}

