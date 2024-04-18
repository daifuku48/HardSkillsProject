package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatsMainContainer(
    stats: StatUiModel,
    buttonNextScreenText: String,
    navigateNextScreen: () -> Unit,
    popBack: () -> Unit,
    backText: String,
) {
    StatisticChart(stats)
    ButtonColumn(
        popBackText = backText,
        popBack = popBack,
        navigateNext = navigateNextScreen,
        navigateNextText = buttonNextScreenText,
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
            buttonNextScreenText = "navigate",
            navigateNextScreen = {},
            popBack = {},
            backText = "Back",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewErrorStats() {
    HardSkillsProjectTheme {
        StatsMainContainer(
            stats = StatUiModel.Error,
            buttonNextScreenText = "navigate",
            navigateNextScreen = {},
            popBack = {},
            backText = "Back",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPendingStats() {
    HardSkillsProjectTheme {
        StatsMainContainer(
            stats = StatUiModel.Pending,
            buttonNextScreenText = "navigate",
            navigateNextScreen = {},
            popBack = {},
            backText = "Back",
        )
    }
}
