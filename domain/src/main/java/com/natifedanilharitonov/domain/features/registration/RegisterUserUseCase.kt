package com.natifedanilharitonov.domain.features.registration

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository

class RegisterUserUseCase(
    private val repository: FirebaseUserRepository,
) : UseCase<RegistrationState, RegistrationEvent> {
    override suspend fun execute(
        state: RegistrationState,
        event: RegistrationEvent,
    ): RegistrationEvent {
        return if (event is RegistrationEvent.RegisterUserEvent) {
            val isLogged = repository.register(state.email, state.password)
            if (isLogged) {
                RegistrationEvent.ShowUserHasLoggedDialog
            } else {
                RegistrationEvent.ShowUserErrorRegistrationDialog
            }
        } else {
            RegistrationEvent.ErrorEvent
        }
    }

    override fun canHandle(event: RegistrationEvent): Boolean {
        return event is RegistrationEvent.RegisterUserEvent
    }
}
