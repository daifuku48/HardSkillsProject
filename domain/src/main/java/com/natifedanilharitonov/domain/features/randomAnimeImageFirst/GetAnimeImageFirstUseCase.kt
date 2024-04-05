package com.natifedanilharitonov.domain.features.randomAnimeImageFirst

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository

class GetAnimeImageFirstUseCase(
    private val repository: RandomAnimeImageRepository,
) : UseCase<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent> {
    override suspend fun execute(
        state: RandomAnimeImageFirstState,
        event: RandomAnimeImageFirstEvent,
    ): RandomAnimeImageFirstEvent {
        return if (event is RandomAnimeImageFirstEvent.GetRandomImageEvent) {
            val image = repository.getImage()
            if (image != null) {
                RandomAnimeImageFirstEvent.RandomImageIsReceived(AnimeImage.ImageAccess(image))
            } else {
                RandomAnimeImageFirstEvent.RandomImageIsReceived(AnimeImage.ImageError)
            }
        } else {
            RandomAnimeImageFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: RandomAnimeImageFirstEvent): Boolean {
        return event is RandomAnimeImageFirstEvent.GetRandomImageEvent
    }
}
