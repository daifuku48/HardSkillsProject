package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatisticChart
import org.koin.androidx.compose.koinViewModel

@Composable
fun StatisticsView(viewModel: StatisticsViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()


    StatisticChart(state.statModel)

    MainButton(
        text = stringResource(id = R.string.next_screen),
        onClick = viewModel::navigateToNextScreen
    )
}






