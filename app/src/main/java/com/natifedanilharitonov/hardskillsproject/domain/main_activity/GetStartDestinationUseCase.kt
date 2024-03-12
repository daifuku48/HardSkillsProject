package com.natifedanilharitonov.hardskillsproject.domain.main_activity

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityEvent
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityState
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class GetStartDestinationUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<MainActivityState, MainActivityEvent> {
    override suspend fun execute(
        state: MainActivityState, event: MainActivityEvent
    ): MainActivityEvent {
        return if (event is MainActivityEvent.GetStartDestinationEvent) {
            val user = repository.getUser()
            val destination =
                if (user != null) Screen.MainScreen.route else Screen.LoginScreen.route
            MainActivityEvent.StartDestinationIsReceivedEvent(destination)
        } else MainActivityEvent.ErrorEvent
    }

    override fun canHandle(event: MainActivityEvent): Boolean {
        return event is MainActivityEvent.GetStartDestinationEvent
    }
}