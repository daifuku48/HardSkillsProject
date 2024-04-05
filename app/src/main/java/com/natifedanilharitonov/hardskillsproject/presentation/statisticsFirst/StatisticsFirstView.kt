package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.components.StatisticsFirstContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun StatisticsFirstView(viewModel: StatisticsFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    StatisticsFirstContainer(model = state.model, getStats = viewModel::getModelStats)

    MainButton(
        text = stringResource(id = R.string.next_screen),
        onClick = viewModel::navigateToNextScreen,
    )
}
