package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatsSecondContainer(
    popToMain: () -> Unit,
    modelLines: PersistentList<Pair<Float, Float>>?,
    modelColumns: PersistentList<Pair<Float, Float>>?,
    popBackScreen: () -> Unit,
    backText: String,
) {
    StatSecondStateView(modelLines = modelLines, modelColumns = modelColumns)
    ButtonColumn(
        popBackText = backText,
        popBack = popBackScreen,
        navigateNext = popToMain,
        navigateNextText = stringResource(id = R.string.back_to_main),
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSecondStats() {
    HardSkillsProjectTheme {
        StatsSecondContainer(
            popToMain = {},


            persistentListOf(
                Pair(0f, 3f),
                Pair(1f, 4f),
                Pair(2f, 7f),
                Pair(3f, 8f),
                Pair(4f, 1f),
                Pair(5f, 33f),
                Pair(6f, 4f),
                Pair(7f, 34f),
                Pair(8f, 4f),
                Pair(9f, 19f),
            ),

            persistentListOf(
                Pair(0f, 41f),
                Pair(1f, 13f),
                Pair(2f, 35f),
                Pair(3f, 19f),
                Pair(4f, 6f),
                Pair(5f, 33f),
                Pair(6f, 4f),
                Pair(7f, 24f),
                Pair(8f, 3f),
                Pair(9f, 14f),
            ),
            popBackScreen = {},
            backText = "Back",
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSecondPendingStats() {
    HardSkillsProjectTheme {
        StatsSecondContainer(
            popToMain = {},
            modelColumns = persistentListOf(),
            modelLines = persistentListOf(),
            popBackScreen = {},
            backText = "Back",
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSecondErrorStats() {
    HardSkillsProjectTheme {
        StatsSecondContainer(
            popToMain = {},
            modelColumns = null,
            modelLines = null,
            popBackScreen = {},
            backText = "Back",
        )
    }
}
