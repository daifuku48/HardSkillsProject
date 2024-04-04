package com.natifedanilharitonov.domain.features.settings_first

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class SettingsFirstEvent : UiEvent {
    data object GetTextEvent : SettingsFirstEvent()
    data class TextIsReceived(val text: StateText) : SettingsFirstEvent()
    data object ErrorEvent : SettingsFirstEvent()
}