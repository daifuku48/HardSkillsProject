package com.natifeuaandroid.domainmodule.features.randomAnimeImage.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageState
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository


class GetAnimeImageUseCase(
    private val repository: RandomAnimeImageRepository,
) : UseCase<RandomAnimeImageState, RandomAnimeImageEvent> {
    override suspend fun execute(
        state: RandomAnimeImageState,
        event: RandomAnimeImageEvent,
    ): RandomAnimeImageEvent {
        return if (event is RandomAnimeImageEvent.GetRandomImageEvent) {
            val animeImageUrl = repository.getImage()
            RandomAnimeImageEvent.RandomImageIsReceived(animeImageUrl)
        } else {
            RandomAnimeImageEvent.ErrorEvent
        }
    }

    override fun canHandle(event: RandomAnimeImageEvent): Boolean {
        return event is RandomAnimeImageEvent.GetRandomImageEvent
    }
}
