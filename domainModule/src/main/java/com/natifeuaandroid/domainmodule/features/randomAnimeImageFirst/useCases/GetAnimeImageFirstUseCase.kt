package com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.useCases


import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstState
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository

class GetAnimeImageFirstUseCase(
    private val repository: RandomAnimeImageRepository,
) : UseCase<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent> {
    override suspend fun execute(
        state: RandomAnimeImageFirstState,
        event: RandomAnimeImageFirstEvent,
    ): RandomAnimeImageFirstEvent {
        return if (event is RandomAnimeImageFirstEvent.GetRandomImageEvent) {
            val image = repository.getImage()
            RandomAnimeImageFirstEvent.RandomImageIsReceived(image)
        } else {
            RandomAnimeImageFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: RandomAnimeImageFirstEvent): Boolean {
        return event is RandomAnimeImageFirstEvent.GetRandomImageEvent
    }
}
