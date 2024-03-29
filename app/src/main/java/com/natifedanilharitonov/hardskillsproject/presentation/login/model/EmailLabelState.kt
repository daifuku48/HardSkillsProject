package com.natifedanilharitonov.hardskillsproject.presentation.login.model

interface EmailLabelState {

    data object ValidEmailLabel : EmailLabelState
    data object ErrorEmailLabel : EmailLabelState
}
