package com.natifeuaandroid.domainmodule.features.userRandomSecond.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondEvent
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondState
import com.natifeuaandroid.domainmodule.repository.UsersRepository


class GetRandomUserSecondUseCase(
    private val repository: UsersRepository,
) : UseCase<UserRandomSecondState, UserRandomSecondEvent> {
    override suspend fun execute(
        state: UserRandomSecondState,
        event: UserRandomSecondEvent,
    ): UserRandomSecondEvent {
        return if (event is UserRandomSecondEvent.GetRandomUserInfo) {
            val user = repository.getUser()
            if (user != null) {
                UserRandomSecondEvent.RandomUserInfoIsReceived(user)
            } else {
                UserRandomSecondEvent.RandomUserErrorEvent
            }
        } else {
            UserRandomSecondEvent.GetRandomUserInfo
        }
    }

    override fun canHandle(event: UserRandomSecondEvent): Boolean {
        return event is UserRandomSecondEvent.GetRandomUserInfo
    }
}
