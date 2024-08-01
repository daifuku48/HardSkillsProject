package com.natifedanilharitonov.hardskillsproject.users

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components.UserInfoContainer
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
                userResult = previewUser(),
                onNextScreen = {},
                backText = "",
                popBackScreen = {},
                isPending = false,
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
                userResult = null,
                onNextScreen = {},
                backText = "",
                popBackScreen = {},
                isPending = false,
            )
        }
        hasText("Oups, something went wrong, users are not existing").assertIsDisplayed()
        hasText("Next Screen").assertIsDisplayed()
    }

    @Test
    fun testPending() {
        rule.setContent {
            UserInfoContainer(
                userResult = null,
                onNextScreen = {},
                backText = "",
                popBackScreen = {},
                isPending = true,
            )
        }
        hasTestTag(PENDING_TAG).assertIsDisplayed()
        hasText("Next Screen").assertIsDisplayed()
    }
}
