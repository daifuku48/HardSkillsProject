package com.natifedanilharitonov.domain.features.random_anime_image_first

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage

sealed class RandomAnimeImageFirstEvent : UiEvent {
    data object ErrorEvent : RandomAnimeImageFirstEvent()
    data object GetRandomImageEvent : RandomAnimeImageFirstEvent()
    data class RandomImageIsReceived(val animeImage: AnimeImage) : RandomAnimeImageFirstEvent()
}