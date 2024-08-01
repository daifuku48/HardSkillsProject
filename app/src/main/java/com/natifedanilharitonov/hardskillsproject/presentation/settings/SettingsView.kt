package com.natifedanilharitonov.hardskillsproject.presentation.settings

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.settings.components.SettingsContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsView(viewModel: SettingsViewModelImpl = koinViewModel()) {
    SettingsContainer(
        signOut = viewModel::signOut,
        navigateToNextScreen = viewModel::navigateToNextScreen,
    )
}
