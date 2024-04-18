package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.info

import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertHasClickAction
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.info.components.InfoContainerView
import org.junit.Rule
import org.junit.Test

class InfoContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testView() {
        rule.setContent {
            InfoContainerView(email = "mock@gmail.com", navigate = {})
        }

        hasText("Email: mock@gmail.com").assertIsDisplayed()
        hasText("Next Screen").assertIsDisplayed()
        hasText("Next Screen").assertHasClickAction()
        hasText("Next Screen").click()
    }
}
