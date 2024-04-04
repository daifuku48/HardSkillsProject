package com.natifedanilharitonov.domain.features.info

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository
import com.natifedanilharitonov.domain.features.info.model.InfoEmailResult

class GetUserInfoUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<InfoState, InfoEvent> {
    override suspend fun execute(state: InfoState, event: InfoEvent): InfoEvent {
        return if (event is InfoEvent.GetUserInfoEvent) {
            val email = repository.getUser()?.email
            if (email != null) {
                InfoEvent.UserDataEventIsReceived(email = InfoEmailResult.Email(email))
            } else InfoEvent.UserDataEventIsReceived(email = InfoEmailResult.ErrorEmail)
        } else InfoEvent.ErrorEvent
    }

    override fun canHandle(event: InfoEvent): Boolean {
        return event is InfoEvent.GetUserInfoEvent
    }
}