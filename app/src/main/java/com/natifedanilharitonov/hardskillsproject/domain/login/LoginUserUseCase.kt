package com.natifedanilharitonov.hardskillsproject.domain.login

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginEvent
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginState

class LoginUserUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<LoginState, LoginEvent> {
    override suspend fun execute(state: LoginState, event: LoginEvent): LoginEvent {
        return if (event is LoginEvent.LoginUserEvent) {
            val isUserLogged = repository.login(state.email, state.password)
            if (isUserLogged) {
                LoginEvent.UserHasLoggedEvent
            } else LoginEvent.ShowUserErrorLoginDialog
        } else LoginEvent.ErrorEvent
    }

    override fun canHandle(event: LoginEvent): Boolean {
        return event is LoginEvent.LoginUserEvent
    }
}