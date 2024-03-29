package com.natifedanilharitonov.domain.use_cases.settings_first

import com.natifedanilharitonov.core.UiEvent

sealed class SettingsFirstEvent : UiEvent {
    data object GetTextEvent : SettingsFirstEvent()
    data class TextIsReceived(val text: com.natifedanilharitonov.domain.use_cases.main.StateText) : SettingsFirstEvent()
    data object ErrorEvent : SettingsFirstEvent()
}