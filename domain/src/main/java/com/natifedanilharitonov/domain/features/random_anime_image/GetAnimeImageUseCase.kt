package com.natifedanilharitonov.domain.features.random_anime_image

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository

class GetAnimeImageUseCase(
    private val repository: RandomAnimeImageRepository
) : UseCase<RandomAnimeImageState, RandomAnimeImageEvent> {
    override suspend fun execute(
        state: RandomAnimeImageState,
        event: RandomAnimeImageEvent
    ): RandomAnimeImageEvent {
        return if (event is RandomAnimeImageEvent.GetRandomImageEvent) {
            val animeImageUrl = repository.getImage()
            if (animeImageUrl == null) {
                RandomAnimeImageEvent.RandomImageIsReceived(AnimeImage.ImageError)
            } else RandomAnimeImageEvent.RandomImageIsReceived(AnimeImage.ImageAccess(image = animeImageUrl))
        } else RandomAnimeImageEvent.ErrorEvent
    }

    override fun canHandle(event: RandomAnimeImageEvent): Boolean {
        return event is RandomAnimeImageEvent.GetRandomImageEvent
    }
}