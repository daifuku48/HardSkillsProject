package com.natifedanilharitonov.domain.features.randomAnimeImage

import com.natifedanilharitonov.core.UiEvent

sealed class RandomAnimeImageEvent : UiEvent {
    data object ErrorEvent : RandomAnimeImageEvent()

    data object GetRandomImageEvent : RandomAnimeImageEvent()

    data class RandomImageIsReceived(val animeImage: AnimeImage) : RandomAnimeImageEvent()
}
