package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.model.DoubleStatUiModel

@Composable
fun StatsSecondContainer(
    popToMain: () -> Unit,
    model: DoubleStatUiModel,
) {
    StatSecondStateView(model = model)

    MainButton(
        text = stringResource(R.string.back_to_main_chart),
        onClick = popToMain,
    )
}
