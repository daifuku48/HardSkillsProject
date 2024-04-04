package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.LottieProgress
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel


@Composable
fun ImageContainer(
    modifier: Modifier = Modifier,
    animeImage: AnimeImageUiModel
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(start = 30.dp, top = 30.dp, end = 30.dp), contentAlignment = Alignment.Center
    ) {
        when (animeImage) {
            is AnimeImageUiModel.ImageAccess -> {
                AsyncImage(
                    model = animeImage.image,
                    contentDescription = "Image",
                    contentScale = ContentScale.FillWidth
                )
            }

            is AnimeImageUiModel.ImageError -> {
                Text(text = stringResource(id = R.string.error_loading_image))
            }

            is AnimeImageUiModel.ImagePending -> {
                LottieProgress()
            }
        }
    }
}

