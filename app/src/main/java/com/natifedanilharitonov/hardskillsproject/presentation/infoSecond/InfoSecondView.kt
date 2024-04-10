package com.natifedanilharitonov.hardskillsproject.presentation.infoSecond

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainViewContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun InfoSecondView(viewModel: InfoSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    MainViewContainer(
        title = stringResource(R.string.info_second_screen),
        text = state.text,
        navigate = viewModel::backToMain,
        buttonText = stringResource(R.string.back_to_main_info),
    )
}
