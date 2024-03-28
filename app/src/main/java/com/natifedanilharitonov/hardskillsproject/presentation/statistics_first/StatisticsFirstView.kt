package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.components.StatisticsFirstContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun StatisticsFirstView(viewModel: StatisticsFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()


    StatisticsFirstContainer(model = state.model, getStats = viewModel::getModelStats)

    MainButton(
        text = stringResource(id = R.string.next_screen),
        onClick = viewModel::navigateToNextScreen
    )
}