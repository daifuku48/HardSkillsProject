package com.natifedanilharitonov.domain.features.main_activity

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository


class GetStartDestinationUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<MainActivityState, MainActivityEvent> {
    override suspend fun execute(
        state: MainActivityState, event: MainActivityEvent
    ): MainActivityEvent {
        return if (event is MainActivityEvent.GetStartDestinationEvent) {
            val user = repository.getUser()
            val destination =
                if (user != null) StartDestinationResult.MainScreenDestination else StartDestinationResult.LoginScreenDestination
            MainActivityEvent.StartDestinationIsReceivedEvent(destination)
        } else MainActivityEvent.ErrorEvent
    }

    override fun canHandle(event: MainActivityEvent): Boolean {
        return event is MainActivityEvent.GetStartDestinationEvent
    }
}