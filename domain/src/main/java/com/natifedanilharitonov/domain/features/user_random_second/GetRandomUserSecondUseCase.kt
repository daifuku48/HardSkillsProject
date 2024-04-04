package com.natifedanilharitonov.domain.features.user_random_second

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.user_random_first.UserResult
import com.natifedanilharitonov.domain.repository.UsersRepository

class GetRandomUserSecondUseCase(
    private val repository: UsersRepository
) : UseCase<UserRandomSecondState, UserRandomSecondEvent> {
    override suspend fun execute(
        state: UserRandomSecondState,
        event: UserRandomSecondEvent
    ): UserRandomSecondEvent {
        return if (event is UserRandomSecondEvent.GetRandomUserInfo) {
            val user = repository.getUser()
            if (user != null) {
                UserRandomSecondEvent.RandomUserInfoIsReceived(UserResult.Model(user))
            } else UserRandomSecondEvent.RandomUserInfoIsReceived(UserResult.Error)
        } else UserRandomSecondEvent.GetRandomUserInfo
    }

    override fun canHandle(event: UserRandomSecondEvent): Boolean {
        return event is UserRandomSecondEvent.GetRandomUserInfo
    }
}