package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.PageTitle
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.IMAGE_TAG

@Composable
fun RandomAnimeImageContainer(
    title: String,
    image: String?,
    refreshImage: () -> Unit,
    textButtonNextScreen: String,
    navigateScreen: () -> Unit,
    textBackToMainScreen: String,
    popBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        PageTitle(text = title)
        ImageContainer(animeImage = image, modifier = Modifier.testTag(IMAGE_TAG))
        Spacer(modifier = Modifier.padding(30.dp))
        RefreshButton(onClick = refreshImage)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AnimeScreenButton(
                text = textButtonNextScreen,
                onClick = navigateScreen,
            )
            AnimeScreenButton(
                text = textBackToMainScreen,
                onClick = popBack,
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAnimeImagePendingMainContainer() {
    HardSkillsProjectTheme {
        RandomAnimeImageContainer(
            image = "",
            refreshImage = {},
            navigateScreen = {},
            textButtonNextScreen = "navigate to next screen",
            title = "Main Screen",
            textBackToMainScreen = "Back To Main Screen",
            popBack = {},
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAnimeImageErrorMainContainer() {
    HardSkillsProjectTheme {
        RandomAnimeImageContainer(
            image = null,
            refreshImage = {},
            navigateScreen = {},
            textButtonNextScreen = "navigate to next screen",
            title = "Main Screen",
            textBackToMainScreen = "Back To Main Screen",
            popBack = {},
        )
    }
}

