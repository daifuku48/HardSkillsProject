package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.components.StatsSecondContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun StatisticsSecondView(viewModel: StatisticsSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    StatsSecondContainer(
        popToMain = viewModel::navigateToMainChart,
        model = state.model,
    )
}
