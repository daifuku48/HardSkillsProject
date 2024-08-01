package com.natifeuaandroid.domainmodule.features.userRandomFirst.useCases


import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstEvent
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstState
import com.natifeuaandroid.domainmodule.repository.UsersRepository


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
                UserRandomFirstEvent.RandomUserIsReceived(user)
            } else {
                UserRandomFirstEvent.ShowUserErrorEvent
            }
        } else {
            UserRandomFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: UserRandomFirstEvent): Boolean {
        return event is UserRandomFirstEvent.GetRandomUserInfoEvent
    }
}
