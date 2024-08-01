package com.natifedanilharitonov.hardskillsproject.main

import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.click
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainViewContainer
import org.junit.Rule
import org.junit.Test

class MainViewContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testMainView() {
        rule.setContent {
            MainViewContainer(
                text = "text text text",
                buttonText = "next button",
                navigate = {},
                title = "Main page",
            )
        }

        hasText("Main page").assertIsDisplayed()
        hasText("next button").assertIsDisplayed()
        hasText("next button").click()
        hasText("text text text").assertIsDisplayed()
    }
}
