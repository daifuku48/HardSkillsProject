package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components

import android.util.Log
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
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.LottieProgress

@Composable
fun ImageContainer(
    modifier: Modifier = Modifier,
    animeImage: String?,
) {
    Box(
        modifier =
        modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(start = 30.dp, top = 30.dp, end = 30.dp),
        contentAlignment = Alignment.Center,
    ) {
        when (animeImage) {
            null -> {
                Text(text = stringResource(id = R.string.error_loading_image))
            }

            stringResource(R.string.empty_string) -> {
                LottieProgress()
            }

            else -> {
                AsyncImage(
                    model = animeImage,
                    contentDescription = "Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth().height(400.dp),
                    onError = { Log.e("ImageContainer", "Error loading image: $animeImage") }
                )
            }
        }
    }
}
