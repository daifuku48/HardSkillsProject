package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.navigation.Navigator

class LoginViewModel(
    reducer: Reducer<LoginState, LoginEvent>,
    useCases: Set<UseCase<LoginState, LoginEvent>>,
    navigator: Navigator
) : BaseViewModel<LoginState, LoginEvent>(reducer, useCases, navigator) {
    override fun createInitState(): LoginState = LoginState()

    override fun handleCaughtEvent(event: LoginEvent) {}
}