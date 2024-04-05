package com.natifedanilharitonov.domain.features.mainSecond

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class MainSecondEvent : UiEvent {
    data object GetMainTextEvent : MainSecondEvent()

    data class MainTextIsReceived(val text: StateText) : MainSecondEvent()

    data object ErrorEvent : MainSecondEvent()
}
