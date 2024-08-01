package com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst

sealed class RandomAnimeImageFirstEvent {
    data object ErrorEvent : RandomAnimeImageFirstEvent()

    data object GetRandomImageEvent : RandomAnimeImageFirstEvent()

    data class RandomImageIsReceived(val animeImage: String?) : RandomAnimeImageFirstEvent()
}
