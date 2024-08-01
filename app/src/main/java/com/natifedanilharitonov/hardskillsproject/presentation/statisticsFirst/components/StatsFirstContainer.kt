package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatsFirstContainer(
    stats: PersistentList<Pair<Float, Float>>?,
    buttonText: String,
    onClickButton: () -> Unit,
    getStats: () -> Unit,
    backText: String,
    popBackScreen: () -> Unit,
) {
    StatisticsFirstContainer(model = stats, getStats = getStats)
    ButtonColumn(
        popBackText = backText,
        popBack = popBackScreen,
        navigateNext = onClickButton,
        navigateNextText = buttonText,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatsFirstContainer() {
    HardSkillsProjectTheme {
        StatsFirstContainer(
            stats =
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
            buttonText = "navigate",
            onClickButton = { },
            getStats = {},
            popBackScreen = {},
            backText = "Back",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatsFirstErrorContainer() {
    HardSkillsProjectTheme {
        StatsFirstContainer(
            stats = null,
            buttonText = "navigate",
            onClickButton = { },
            getStats = {},
            popBackScreen = {},
            backText = "Back",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatsFirstPendingContainer() {
    HardSkillsProjectTheme {
        StatsFirstContainer(
            stats = persistentListOf(),
            buttonText = "navigate",
            onClickButton = { },
            getStats = {},
            popBackScreen = {},
            backText = "Back",
        )
    }
}
