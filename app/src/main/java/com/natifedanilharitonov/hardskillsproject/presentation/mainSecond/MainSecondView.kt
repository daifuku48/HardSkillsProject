package com.natifedanilharitonov.hardskillsproject.presentation.mainSecond

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainViewContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainSecondMockView(viewModel: MainSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    MainViewContainer(
        title = stringResource(id = R.string.main_second_screen),
        text = state.text,
        navigate = viewModel::backToMain,
        buttonText = stringResource(R.string.back_to_main),
    )
}
