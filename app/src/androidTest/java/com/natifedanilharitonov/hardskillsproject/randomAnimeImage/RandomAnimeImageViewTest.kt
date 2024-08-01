package com.natifedanilharitonov.hardskillsproject.randomAnimeImage

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components.RandomAnimeImageContainer
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.REFRESH_BUTTON_TAG
import org.junit.Rule
import org.junit.Test

class RandomAnimeImageViewTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testImageView() {
        rule.setContent {
            RandomAnimeImageContainer(
                image = "image.jpeg",
                navigateScreen = {},
                refreshImage = {},
                textButtonNextScreen = "navigate button",
                title = "Anime Image",
                textBackToMainScreen = "Back",
                popBack = {},
            )
        }

        hasText("Anime Image").assertIsDisplayed()
        hasText("navigate button").assertIsDisplayed()
        hasText("navigate button").click()
        hasText("Back").assertIsDisplayed()
        hasTestTag(REFRESH_BUTTON_TAG).assertIsDisplayed()
        hasTestTag(REFRESH_BUTTON_TAG).click()
    }
}
