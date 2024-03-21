package com.natifedanilharitonov.hardskillsproject.domain.use_cases.registration

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationEvent
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationState

class RegisterUserUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<RegistrationState, RegistrationEvent> {
    override suspend fun execute(
        state: RegistrationState,
        event: RegistrationEvent
    ): RegistrationEvent {
        return if (event is RegistrationEvent.RegisterUserEvent) {
            val isLogged = repository.register(state.email, state.password)
            if (isLogged) {
                RegistrationEvent.ShowUserHasLoggedDialog
            } else {
                RegistrationEvent.HideUserErrorRegistrationDialog
            }
        } else RegistrationEvent.ErrorEvent
    }

    override fun canHandle(event: RegistrationEvent): Boolean {
        return event is RegistrationEvent.RegisterUserEvent
    }
}