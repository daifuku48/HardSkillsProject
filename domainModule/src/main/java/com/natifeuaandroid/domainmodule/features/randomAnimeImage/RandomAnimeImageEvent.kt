package com.natifeuaandroid.domainmodule.features.randomAnimeImage

sealed class RandomAnimeImageEvent {
    data object ErrorEvent : RandomAnimeImageEvent()

    data object GetRandomImageEvent : RandomAnimeImageEvent()

    data class RandomImageIsReceived(val animeImage: String?) : RandomAnimeImageEvent()
}
