package com.natifedanilharitonov.domain.features.settingsFirst

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class SettingsFirstEvent : UiEvent {
    data object GetTextEvent : SettingsFirstEvent()

    data class TextIsReceived(val text: StateText) : SettingsFirstEvent()

    data object ErrorEvent : SettingsFirstEvent()
}
