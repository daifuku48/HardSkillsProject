package com.natifeuaandroid.domainmodule.features.info.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.info.InfoEvent
import com.natifeuaandroid.domainmodule.features.info.InfoState
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository


class GetUserInfoUseCase(
    private val repository: FirebaseUserRepository,
) : UseCase<InfoState, InfoEvent> {
    override suspend fun execute(
        state: InfoState,
        event: InfoEvent,
    ): InfoEvent {
        return if (event is InfoEvent.GetUserInfoEvent) {
            val email = repository.getUser()?.email
            if (email != null) {
                InfoEvent.UserDataEventIsReceived(email = email)
            } else {
                InfoEvent.EmailErrorEvent
            }
        } else {
            InfoEvent.ErrorEvent
        }
    }

    override fun canHandle(event: InfoEvent): Boolean = event is InfoEvent.GetUserInfoEvent
}
