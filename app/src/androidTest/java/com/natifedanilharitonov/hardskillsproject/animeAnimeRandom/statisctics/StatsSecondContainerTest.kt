package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.statisctics

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.components.StatsSecondContainer
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.model.DoubleStatUiModel
import com.natifedanilharitonov.hardskillsproject.utils.TestTags
import kotlinx.collections.immutable.persistentListOf
import org.junit.Rule
import org.junit.Test

class StatsSecondContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testView() {
        rule.setContent {
            StatsSecondContainer(
                popToMain = {},
                model =
                    DoubleStatUiModel.Model(
                        modelColumns =
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
                        modelLines =
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
                    ),
                popBackScreen = {},
                backText = "Back",
            )
        }

        hasTestTag(TestTags.CHART_TAG).assertIsDisplayed()
        hasText("Back to main chart").assertIsDisplayed()
        hasText("Back to main chart").click()
    }

    @Test
    fun testError() {
        rule.setContent {
            StatsSecondContainer(
                popToMain = {},
                model =
                    DoubleStatUiModel.Error,
                popBackScreen = {},
                backText = "Back",
            )
        }

        hasText("Error stats model").assertIsDisplayed()
        hasText("Back to main chart").assertIsDisplayed()
    }

    @Test
    fun testPending() {
        rule.setContent {
            StatsSecondContainer(
                popToMain = {},
                model =
                    DoubleStatUiModel.Pending,
                popBackScreen = {},
                backText = "Back",
            )
        }

        hasTestTag(TestTags.PENDING_TAG).assertIsDisplayed()
        hasText("Back to main chart").assertIsDisplayed()
    }
}
