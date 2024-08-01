package com.natifeuaandroid.domainmodule.features.mainActivity

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository


class GetStartDestinationUseCase(
    private val repository: FirebaseUserRepository,
) : UseCase<MainActivityState, MainActivityEvent> {
    override suspend fun execute(
        state: MainActivityState,
        event: MainActivityEvent,
    ): MainActivityEvent =
        if (event is MainActivityEvent.GetStartDestinationEvent) {
            val user = repository.getUser()
            val destination =
                if (user != null) MAIN_ROUTE else LOGIN_ROUTE
            MainActivityEvent.StartDestinationIsReceivedEvent(destination)
        } else {
            MainActivityEvent.ErrorEvent
        }

    override fun canHandle(event: MainActivityEvent): Boolean =
        event is MainActivityEvent.GetStartDestinationEvent

    companion object {
        private const val LOGIN_ROUTE = "LOGIN_ROUTE"
        private const val MAIN_ROUTE = "MAIN_ROUTE"
    }
}
