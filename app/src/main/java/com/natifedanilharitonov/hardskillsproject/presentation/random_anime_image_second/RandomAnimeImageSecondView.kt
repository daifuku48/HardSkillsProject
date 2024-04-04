package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_second

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.PageTitle
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components.AnimeScreenButton
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components.ImageContainer
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components.RefreshButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun RandomAnimeImageSecondView(viewModel: RandomAnimeImageSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PageTitle(text = stringResource(R.string.second_anime_page))
        ImageContainer(animeImage = state.image)
        Spacer(modifier = Modifier.padding(30.dp))
        RefreshButton(onClick = viewModel::getAnimeImage)
        AnimeScreenButton(
            text = stringResource(id = R.string.back_to_main),
            onClick = viewModel::popBackToMain
        )
    }
}