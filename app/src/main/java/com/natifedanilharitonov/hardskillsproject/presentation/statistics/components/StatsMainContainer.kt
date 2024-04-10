package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatsMainContainer(
    stats: StatUiModel,
    buttonText: String,
    onClickButton: () -> Unit,
) {
    StatisticChart(stats)

    MainButton(
        text = buttonText,
        onClick = onClickButton,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStats() {
    HardSkillsProjectTheme {
        StatsMainContainer(
            stats =
                StatUiModel.Model(
                    persistentListOf(
                        Pair(0f, 3f),
                        Pair(1f, 1f),
                        Pair(2f, 2f),
                        Pair(3f, 4f),
                        Pair(4f, 5f),
                        Pair(5f, 2f),
                        Pair(6f, 4f),
                        Pair(7f, 5f),
                        Pair(8f, 2f),
                        Pair(9f, 5f),
                    ),
                ),
            buttonText = "navigate",
            onClickButton = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewErrorStats() {
    HardSkillsProjectTheme {
        StatsMainContainer(
            stats = StatUiModel.Error,
            buttonText = "navigate",
            onClickButton = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPendingStats() {
    HardSkillsProjectTheme {
        StatsMainContainer(
            stats = StatUiModel.Pending,
            buttonText = "navigate",
            onClickButton = {},
        )
    }
}
