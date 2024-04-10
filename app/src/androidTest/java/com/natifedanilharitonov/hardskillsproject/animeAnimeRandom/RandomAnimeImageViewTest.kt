package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom

import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class RandomAnimeImageViewTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testImageView() =
        runTest {
            rule.setContent {
            }
        }
}
