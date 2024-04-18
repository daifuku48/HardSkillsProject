package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.users

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components.UserInfoContainer
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserResultUiModel
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PENDING_TAG
import org.junit.Rule
import org.junit.Test

class UserInfoContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testView() {
        rule.setContent {
            UserInfoContainer(
                userResult =
                    UserResultUiModel.Model(
                        user = previewUser(),
                    ),
                onNextScreen = {},
                backText = "",
                popBackScreen = {},
            )
        }

        hasText("Name").assertIsDisplayed()
        hasText("Email").assertIsDisplayed()
        hasText("Gender").assertIsDisplayed()
        hasText("Next Screen").assertIsDisplayed()
        hasText("Next Screen").click()
    }

    @Test
    fun testError() {
        rule.setContent {
            UserInfoContainer(
                userResult =
                    UserResultUiModel.Error,
                onNextScreen = {},
                backText = "",
                popBackScreen = {},
            )
        }
        hasText("Oups, something went wrong, users are not existing").assertIsDisplayed()
        hasText("Next Screen").assertIsDisplayed()
    }

    @Test
    fun testPending() {
        rule.setContent {
            UserInfoContainer(
                userResult =
                    UserResultUiModel.Pending,
                onNextScreen = {},
                backText = "",
                popBackScreen = {},
            )
        }
        hasTestTag(PENDING_TAG).assertIsDisplayed()
        hasText("Next Screen").assertIsDisplayed()
    }
}
