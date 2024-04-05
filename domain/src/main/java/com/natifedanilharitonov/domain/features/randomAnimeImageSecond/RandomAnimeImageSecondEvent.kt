package com.natifedanilharitonov.domain.features.randomAnimeImageSecond

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage

sealed class RandomAnimeImageSecondEvent : UiEvent {
    data object ErrorEvent : RandomAnimeImageSecondEvent()
    data object GetRandomImageEvent : RandomAnimeImageSecondEvent()
    data class RandomImageIsReceived(val animeImage: AnimeImage) : RandomAnimeImageSecondEvent()
}