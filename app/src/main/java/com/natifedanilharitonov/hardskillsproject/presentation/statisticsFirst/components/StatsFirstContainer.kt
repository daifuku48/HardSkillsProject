package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatsFirstContainer(
    stats: StatUiModel,
    buttonText: String,
    onClickButton: () -> Unit,
    getStats: () -> Unit,
) {
    StatisticsFirstContainer(model = stats, getStats = getStats)

    MainButton(
        text = buttonText,
        onClick = onClickButton,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatsFirstContainer() {
    HardSkillsProjectTheme {
        StatsFirstContainer(
            stats =
                StatUiModel.Model(
                    model =
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
            onClickButton = { },
            getStats = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatsFirstErrorContainer() {
    HardSkillsProjectTheme {
        StatsFirstContainer(
            stats =
                StatUiModel.Error,
            buttonText = "navigate",
            onClickButton = { },
            getStats = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatsFirstPendingContainer() {
    HardSkillsProjectTheme {
        StatsFirstContainer(
            stats = StatUiModel.Pending,
            buttonText = "navigate",
            onClickButton = { },
            getStats = {},
        )
    }
}
