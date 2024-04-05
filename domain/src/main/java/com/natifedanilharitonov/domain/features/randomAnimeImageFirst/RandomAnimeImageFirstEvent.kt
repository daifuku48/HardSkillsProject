package com.natifedanilharitonov.domain.features.randomAnimeImageFirst

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage

sealed class RandomAnimeImageFirstEvent : UiEvent {
    data object ErrorEvent : RandomAnimeImageFirstEvent()

    data object GetRandomImageEvent : RandomAnimeImageFirstEvent()

    data class RandomImageIsReceived(val animeImage: AnimeImage) : RandomAnimeImageFirstEvent()
}
