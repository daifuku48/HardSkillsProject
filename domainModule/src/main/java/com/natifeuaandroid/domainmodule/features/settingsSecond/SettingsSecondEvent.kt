package com.natifeuaandroid.domainmodule.features.settingsSecond

sealed class SettingsSecondEvent {
    data object GetTextEvent : SettingsSecondEvent()

    data class TextIsReceived(val text: String?) : SettingsSecondEvent()

    data object ErrorEvent : SettingsSecondEvent()
}
