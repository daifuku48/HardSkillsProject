package com.natifedanilharitonov.domain.use_cases.main_second

import com.natifedanilharitonov.core.UiEvent

sealed class MainSecondEvent : UiEvent {
    data object GetMainTextEvent : MainSecondEvent()
    data class MainTextIsReceived(val text: com.natifedanilharitonov.domain.use_cases.main.StateText) : MainSecondEvent()
    data object ErrorEvent : MainSecondEvent()
}