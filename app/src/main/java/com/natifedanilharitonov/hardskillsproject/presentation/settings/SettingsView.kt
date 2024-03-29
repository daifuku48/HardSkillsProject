package com.natifedanilharitonov.hardskillsproject.presentation.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.settings.components.SettingsContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsView(viewModel: SettingsViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(state.isSignOutUser) {
        if (state.isSignOutUser) {
            viewModel.navigateToLogin()
        }
    }

    SettingsContainer(
        signOut = viewModel::signOut,
        navigateToNextScreen = viewModel::navigateToNextScreen
    )
}


