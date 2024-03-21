package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

sealed class SettingsFirstEvent : UiEvent {
    data object GetTextEvent : SettingsFirstEvent()
    data class TextIsReceived(val text: StateText) : SettingsFirstEvent()
    data object ErrorEvent : SettingsFirstEvent()
}