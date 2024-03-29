package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainText
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainTitle
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainFirstView(viewModel: MainFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()
    MainTitle(text = stringResource(R.string.main_first_screen))

    MainText(text = state.text)

    MainButton(
        text = stringResource(id = R.string.next_screen),
        onClick = viewModel::navigateToNextScreen
    )
}