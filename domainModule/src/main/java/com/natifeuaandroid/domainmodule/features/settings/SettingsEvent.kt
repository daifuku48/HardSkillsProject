package com.natifeuaandroid.domainmodule.features.settings

sealed class SettingsEvent {
    data object SignOutUserEvent : SettingsEvent()

    data object UserIsSignedOutEvent : SettingsEvent()

    data object ErrorEvent : SettingsEvent()
}
