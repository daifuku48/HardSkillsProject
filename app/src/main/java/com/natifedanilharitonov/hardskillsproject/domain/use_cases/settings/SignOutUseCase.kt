package com.natifedanilharitonov.hardskillsproject.domain.use_cases.settings

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsEvent
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsState

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