package com.natifedanilharitonov.hardskillsproject.presentation.main_second

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
fun MainSecondMockView(viewModel: MainSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    MainTitle(text = stringResource(R.string.main_second_screen))

    MainText(text = state.text)

    MainButton(
        text = stringResource(R.string.back_to_main),
        onClick = viewModel::backToMain
    )
}