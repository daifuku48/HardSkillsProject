package com.natifedanilharitonov.domain.use_cases.main_first

import com.natifedanilharitonov.core.UiEvent

sealed class MainFirstEvent : UiEvent {
    data object GetMainTextEvent : MainFirstEvent()
    data class MainTextIsReceived(val text: com.natifedanilharitonov.domain.use_cases.main.StateText) : MainFirstEvent()
    data object ErrorEvent : MainFirstEvent()
}