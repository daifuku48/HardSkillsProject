package com.natifedanilharitonov.hardskillsproject.presentation.settings

import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class SettingsEvent : UiEvent {
    data object SignOutUserEvent : SettingsEvent()
    data object UserIsSignedOutEvent : SettingsEvent()
    data object ErrorEvent : SettingsEvent()
}