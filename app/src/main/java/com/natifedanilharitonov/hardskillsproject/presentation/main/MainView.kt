package com.natifedanilharitonov.hardskillsproject.presentation.main

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
fun MainView(viewModel: MainViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    MainTitle(text = stringResource(R.string.main_screen_))

    MainText(text = state.text)

    MainButton(
        text = stringResource(id = R.string.next_screen),
        onClick = viewModel::navigateToNextScreen
    )
}