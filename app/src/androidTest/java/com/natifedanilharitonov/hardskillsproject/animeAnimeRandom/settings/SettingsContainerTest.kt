package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.settings

import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.settings.components.SettingsContainer
import org.junit.Rule
import org.junit.Test

class SettingsContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testView() {
        rule.setContent {
            SettingsContainer(signOut = { }, navigateToNextScreen = {})
        }

        hasText("Sign Out").assertIsDisplayed()
        hasText("Sign Out").click()

        hasText("Next Screen").assertIsDisplayed()
        hasText("Next Screen").click()
    }
}
