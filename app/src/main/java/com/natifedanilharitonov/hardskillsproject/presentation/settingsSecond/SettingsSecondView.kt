package com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainViewContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsSecondView(viewModel: SettingsSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    MainViewContainer(
        title = stringResource(R.string.second_settings_screen),
        text = state.text,
        navigate = viewModel::backToStart,
        buttonText = stringResource(R.string.back_to_main_settings),
    )
}
