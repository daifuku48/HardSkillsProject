package com.natifedanilharitonov.domain.use_cases.settings_second

import com.natifedanilharitonov.core.UiEvent

sealed class SettingsSecondEvent : UiEvent {
    data object GetTextEvent : SettingsSecondEvent()
    data class TextIsReceived(val text: com.natifedanilharitonov.domain.use_cases.main.StateText) : SettingsSecondEvent()
    data object ErrorEvent : SettingsSecondEvent()
}