package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components.RandomAnimeImageContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun RandomAnimeImageView(viewModel: RandomAnimeImageViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    RandomAnimeImageContainer(
        title = stringResource(id = R.string.main_anime_page),
        image = state.image,
        refreshImage = viewModel::refreshImage,
        navigate = viewModel::navigateToNextScreen,
        textButton = stringResource(id = R.string.next_screen),
    )
}
