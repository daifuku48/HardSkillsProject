package com.natifedanilharitonov.domain.use_cases.settings

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository

class SignOutUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<SettingsState, SettingsEvent> {
    override suspend fun execute(state: SettingsState, event: SettingsEvent): SettingsEvent {
        return if (event is SettingsEvent.SignOutUserEvent) {
            repository.signOut()
            SettingsEvent.UserIsSignedOutEvent
        } else SettingsEvent.ErrorEvent
    }

    override fun canHandle(event: SettingsEvent): Boolean {
        return event is SettingsEvent.SignOutUserEvent
    }
}