package com.natifedanilharitonov.domain.features.mainFirst

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.main.StateText

sealed class MainFirstEvent : UiEvent {
    data object GetMainTextEvent : MainFirstEvent()

    data class MainTextIsReceived(val text: StateText) : MainFirstEvent()

    data object ErrorEvent : MainFirstEvent()
}
