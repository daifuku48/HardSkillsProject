package com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainViewContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsFirstView(viewModel: SettingsFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    MainViewContainer(
        title = stringResource(R.string.settings_first_screen),
        text = state.text,
        navigate = viewModel::navigateToNextScreen,
        buttonText = stringResource(id = R.string.next_screen),
    )
}
