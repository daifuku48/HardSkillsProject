package com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond

sealed class RandomAnimeImageSecondEvent {
    data object ErrorEvent : RandomAnimeImageSecondEvent()
    data object GetRandomImageEvent : RandomAnimeImageSecondEvent()
    data class RandomImageIsReceived(val animeImage: String?) : RandomAnimeImageSecondEvent()
}