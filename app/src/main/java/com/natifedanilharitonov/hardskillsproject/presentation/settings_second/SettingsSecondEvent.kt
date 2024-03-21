package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

sealed class SettingsSecondEvent : UiEvent {
    data object GetTextEvent : SettingsSecondEvent()
    data class TextIsReceived(val text: StateText) : SettingsSecondEvent()
    data object ErrorEvent : SettingsSecondEvent()
}