package com.natifedanilharitonov.domain.features.settings

import com.natifedanilharitonov.core.UiEvent

sealed class SettingsEvent : UiEvent {
    data object SignOutUserEvent : SettingsEvent()

    data object UserIsSignedOutEvent : SettingsEvent()

    data object ErrorEvent : SettingsEvent()
}
