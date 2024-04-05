package com.natifedanilharitonov.domain.features.userRandomFirst

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.UsersRepository

class GetRandomUserFirstUseCase(
    private val userRepository: UsersRepository,
) : UseCase<UserRandomFirstState, UserRandomFirstEvent> {
    override suspend fun execute(
        state: UserRandomFirstState,
        event: UserRandomFirstEvent,
    ): UserRandomFirstEvent {
        return if (event is UserRandomFirstEvent.GetRandomUserInfoEvent) {
            val user = userRepository.getUser()

            if (user != null) {
                UserRandomFirstEvent.RandomUserIsReceived(UserResult.Model(user))
            } else {
                UserRandomFirstEvent.RandomUserIsReceived(UserResult.Error)
            }
        } else {
            UserRandomFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: UserRandomFirstEvent): Boolean {
        return event is UserRandomFirstEvent.GetRandomUserInfoEvent
    }
}
