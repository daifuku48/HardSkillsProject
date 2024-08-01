package com.natifedanilharitonov.hardskillsproject.presentation.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.info.components.InfoContainerView
import org.koin.androidx.compose.koinViewModel

@Composable
fun InfoView(viewModel: InfoViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    InfoContainerView(email = state.email, navigate = viewModel::navigateToNextScreen)
}
