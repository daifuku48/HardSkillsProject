package com.natifedanilharitonov.domain.features.random_anime_image_second

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage

sealed class RandomAnimeImageSecondEvent : UiEvent {
    data object ErrorEvent : RandomAnimeImageSecondEvent()
    data object GetRandomImageEvent : RandomAnimeImageSecondEvent()
    data class RandomImageIsReceived(val animeImage: AnimeImage) : RandomAnimeImageSecondEvent()
}