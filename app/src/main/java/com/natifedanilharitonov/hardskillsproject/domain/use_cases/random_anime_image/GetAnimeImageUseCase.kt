package com.natifedanilharitonov.hardskillsproject.domain.use_cases.random_anime_image

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.RandomAnimeImageRepository
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.AnimeImage
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageEvent
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageState

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