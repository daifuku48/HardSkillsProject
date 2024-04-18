package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components.RandomAnimeImageContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun RandomAnimeImageFirstView(viewModel: RandomAnimeImageFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    RandomAnimeImageContainer(
        title = stringResource(id = R.string.first_anime_page),
        image = state.image,
        refreshImage = viewModel::refreshImage,
        navigateScreen = viewModel::navigateToNextScreen,
        textButtonNextScreen = stringResource(id = R.string.next_screen),
        popBack = viewModel::popBackScreen,
        textBackToMainScreen = stringResource(R.string.back),
    )
}
