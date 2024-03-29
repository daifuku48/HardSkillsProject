package com.natifedanilharitonov.hardskillsproject.presentation.login.model

interface PasswordLabelState {
    data object ValidPassword : PasswordLabelState
    data object ErrorPassword : PasswordLabelState
}

