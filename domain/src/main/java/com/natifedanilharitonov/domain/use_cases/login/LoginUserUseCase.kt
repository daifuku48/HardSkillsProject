package com.natifedanilharitonov.domain.use_cases.login

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository

class LoginUserUseCase(
    private val repository: FirebaseUserRepository
) : UseCase<LoginState, LoginEvent> {
    override suspend fun execute(state: LoginState, event: LoginEvent): LoginEvent {
        return if (event is LoginEvent.LoginUserEvent) {
            val isUserLogged = repository.login(state.emailText, state.passwordText)
            if (isUserLogged) {
                LoginEvent.UserHasLoggedEvent
            } else LoginEvent.ShowUserErrorLoginDialog
        } else LoginEvent.ErrorEvent
    }

    override fun canHandle(event: LoginEvent): Boolean {
        return event is LoginEvent.LoginUserEvent
    }
}