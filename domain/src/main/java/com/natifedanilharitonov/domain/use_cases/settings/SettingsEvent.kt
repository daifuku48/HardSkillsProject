package com.natifedanilharitonov.domain.use_cases.settings

import com.natifedanilharitonov.core.UiEvent

sealed class SettingsEvent : UiEvent {
    data object SignOutUserEvent : SettingsEvent()
    data object UserIsSignedOutEvent : SettingsEvent()
    data object ErrorEvent : SettingsEvent()
}