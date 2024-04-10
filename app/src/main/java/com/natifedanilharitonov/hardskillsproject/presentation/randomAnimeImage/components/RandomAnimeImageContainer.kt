package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.PageTitle
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model.AnimeImageUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun RandomAnimeImageContainer(
    title: String,
    image: AnimeImageUiModel,
    refreshImage: () -> Unit,
    textButton: String,
    navigate: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        PageTitle(text = title)
        ImageContainer(animeImage = image)
        Spacer(modifier = Modifier.padding(30.dp))
        RefreshButton(onClick = refreshImage)
        AnimeScreenButton(
            text = textButton,
            onClick = navigate,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAnimeImagePendingContainer() {
    HardSkillsProjectTheme {
        RandomAnimeImageContainer(
            image = AnimeImageUiModel.ImagePending,
            refreshImage = {},
            navigate = {},
            textButton = "navigate to next screen",
            title = "Main Screen",
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAnimeImageErrorContainer() {
    HardSkillsProjectTheme {
        RandomAnimeImageContainer(
            image = AnimeImageUiModel.ImageError,
            refreshImage = {},
            navigate = {},
            textButton = "navigate to next screen",
            title = "Main Screen",
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAnimeImageContainer() {
    HardSkillsProjectTheme {
        RandomAnimeImageContainer(
            image =
                AnimeImageUiModel.ImageAccess(
                    Bitmap.createBitmap(
                        100,
                        100,
                        Bitmap.Config.ARGB_8888,
                    ),
                ),
            refreshImage = {},
            navigate = {},
            textButton = "navigate to next screen",
            title = "Main Screen",
        )
    }
}
