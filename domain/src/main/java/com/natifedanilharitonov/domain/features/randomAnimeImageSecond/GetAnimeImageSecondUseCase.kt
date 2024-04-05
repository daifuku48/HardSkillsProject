package com.natifedanilharitonov.domain.features.randomAnimeImageSecond

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository

class GetAnimeImageSecondUseCase(
    private val repository: RandomAnimeImageRepository,
) : UseCase<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent> {
    override suspend fun execute(
        state: RandomAnimeImageSecondState,
        event: RandomAnimeImageSecondEvent,
    ): RandomAnimeImageSecondEvent {
        return if (event is RandomAnimeImageSecondEvent.GetRandomImageEvent) {
            val image = repository.getImage()
            if (image != null) {
                RandomAnimeImageSecondEvent.RandomImageIsReceived(AnimeImage.ImageAccess(image))
            } else {
                RandomAnimeImageSecondEvent.RandomImageIsReceived(AnimeImage.ImageError)
            }
        } else {
            RandomAnimeImageSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: RandomAnimeImageSecondEvent): Boolean {
        return event is RandomAnimeImageSecondEvent.GetRandomImageEvent
    }
}
