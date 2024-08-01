package com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.useCases


import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondState
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository

class GetAnimeImageSecondUseCase(
    private val repository: RandomAnimeImageRepository,
) : UseCase<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent> {
    override suspend fun execute(
        state: RandomAnimeImageSecondState,
        event: RandomAnimeImageSecondEvent,
    ): RandomAnimeImageSecondEvent {
        return if (event is RandomAnimeImageSecondEvent.GetRandomImageEvent) {
            val image = repository.getImage()
            RandomAnimeImageSecondEvent.RandomImageIsReceived(image)
        } else {
            RandomAnimeImageSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: RandomAnimeImageSecondEvent): Boolean {
        return event is RandomAnimeImageSecondEvent.GetRandomImageEvent
    }
}
