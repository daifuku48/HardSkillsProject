package com.natifedanilharitonov.domain.features.settings_second

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class SettingsSecondEvent : UiEvent {
    data object GetTextEvent : SettingsSecondEvent()
    data class TextIsReceived(val text: StateText) : SettingsSecondEvent()
    data object ErrorEvent : SettingsSecondEvent()
}