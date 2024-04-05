package com.natifedanilharitonov.domain.features.infoFirst

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class InfoFirstEvent : UiEvent {
    data object GetTextEvent : InfoFirstEvent()

    data class TextReceivedEvent(val text: StateText) : InfoFirstEvent()

    data object ErrorEvent : InfoFirstEvent()
}
