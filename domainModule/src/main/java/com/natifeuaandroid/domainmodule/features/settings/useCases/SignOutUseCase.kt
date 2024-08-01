package com.natifeuaandroid.domainmodule.features.settings.useCases


import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.settings.SettingsEvent
import com.natifeuaandroid.domainmodule.features.settings.SettingsState
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository

class SignOutUseCase(
    private val repository: FirebaseUserRepository,
) : UseCase<SettingsState, SettingsEvent> {
    override suspend fun execute(
        state: SettingsState,
        event: SettingsEvent,
    ): SettingsEvent {
        return if (event is SettingsEvent.SignOutUserEvent) {
            repository.signOut()
            SettingsEvent.UserIsSignedOutEvent
        } else {
            SettingsEvent.ErrorEvent
        }
    }

    override fun canHandle(event: SettingsEvent): Boolean {
        return event is SettingsEvent.SignOutUserEvent
    }
}
