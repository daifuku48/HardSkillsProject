package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats

@Composable
fun StatsSecondContainer(
    popToMain: () -> Unit,
    model: DoubleStatModel
) {
    StatSecondStateView(model = model)

    MainButton(
        text = stringResource(R.string.back_to_main_chart),
        onClick = popToMain
    )
}


