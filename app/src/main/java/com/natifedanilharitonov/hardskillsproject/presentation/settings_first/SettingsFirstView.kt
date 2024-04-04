package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainText
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.PageTitle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsFirstView(viewModel: SettingsFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    PageTitle(text = stringResource(R.string.settings_first_screen))

    MainText(text = state.text)

    MainButton(
        text = stringResource(id = R.string.next_screen),
        onClick = viewModel::navigateToNextScreen
    )
}