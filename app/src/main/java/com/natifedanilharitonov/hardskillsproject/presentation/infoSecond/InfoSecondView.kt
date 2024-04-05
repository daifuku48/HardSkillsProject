package com.natifedanilharitonov.hardskillsproject.presentation.infoSecond

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
fun InfoSecondView(viewModel: InfoSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    PageTitle(text = stringResource(R.string.info_second_screen))

    MainText(text = state.text)

    MainButton(
        text = stringResource(R.string.back_to_main_info),
        onClick = viewModel::backToMain,
    )
}