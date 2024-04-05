package com.natifedanilharitonov.domain.features.infoSecond

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class InfoSecondEvent : UiEvent {
    data object GetTextEvent : InfoSecondEvent()

    data class TextReceivedEvent(val text: StateText) : InfoSecondEvent()

    data object ErrorEvent : InfoSecondEvent()
}