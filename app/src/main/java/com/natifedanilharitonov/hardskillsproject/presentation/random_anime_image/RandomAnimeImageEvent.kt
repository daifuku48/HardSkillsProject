package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class RandomAnimeImageEvent : UiEvent {
    data object ErrorEvent : RandomAnimeImageEvent()
    data object GetRandomImageEvent : RandomAnimeImageEvent()
    data class RandomImageIsReceived(val animeImage: AnimeImage) : RandomAnimeImageEvent()
}