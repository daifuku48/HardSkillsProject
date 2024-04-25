package com.natifedanilharitonov.hardskillsproject.statisctics

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatsMainContainer
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.CHART_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PENDING_TAG
import kotlinx.collections.immutable.persistentListOf
import org.junit.Rule
import org.junit.Test

class StatsMainContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testView() {
        rule.setContent {
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

        hasText("Back").assertIsDisplayed()
        hasText("Back").click()
        hasTestTag(CHART_TAG).assertIsDisplayed()
        hasText("navigate").assertIsDisplayed()
        hasText("navigate").click()
    }

    @Test
    fun testError() {
        rule.setContent {
            StatsMainContainer(
                stats = StatUiModel.Error,
                buttonNextScreenText = "navigate",
                navigateNextScreen = {},
                popBack = {},
                backText = "Back",
            )
        }

        hasText("Error stats model").assertIsDisplayed()
        hasText("navigate").assertIsDisplayed()
    }

    @Test
    fun testPending() {
        rule.setContent {
            StatsMainContainer(
                stats = StatUiModel.Pending,
                buttonNextScreenText = "navigate",
                navigateNextScreen = {},
                popBack = {},
                backText = "Back",
            )
        }

        hasTestTag(PENDING_TAG).assertIsDisplayed()
        hasText("navigate").assertIsDisplayed()
    }
}
