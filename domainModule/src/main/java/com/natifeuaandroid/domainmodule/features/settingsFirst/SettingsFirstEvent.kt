package com.natifeuaandroid.domainmodule.features.settingsFirst

sealed class SettingsFirstEvent {
    data object GetTextEvent : SettingsFirstEvent()

    data class TextIsReceived(val text: String?) : SettingsFirstEvent()

    data object ErrorEvent : SettingsFirstEvent()
}
