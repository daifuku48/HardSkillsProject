package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class InfoEvent : UiEvent {
    data object GetUserInfoEvent : InfoEvent()
    data class UserDataEventIsReceived(val email: String) : InfoEvent()
    data object ErrorEvent : InfoEvent()
}