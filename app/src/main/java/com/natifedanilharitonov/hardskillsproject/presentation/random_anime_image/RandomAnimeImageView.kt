package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components.AnimeScreenButton
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components.ImageContainer
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components.RefreshButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun RandomAnimeImageView(viewModel: RandomAnimeImageViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    AnimeScreenButton(onClick = viewModel::navigateToNextScreen)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            ImageContainer(animeImage = state.image)
            Spacer(modifier = Modifier.padding(30.dp))
            RefreshButton(onClick = viewModel::refreshImage)
        }
    }
}