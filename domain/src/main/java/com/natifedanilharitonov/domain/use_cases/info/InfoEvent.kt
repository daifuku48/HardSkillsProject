package com.natifedanilharitonov.domain.use_cases.info

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.use_cases.info.model.InfoEmailResult

sealed class InfoEvent : UiEvent {
    data object GetUserInfoEvent : InfoEvent()
    data class UserDataEventIsReceived(val email: InfoEmailResult) : InfoEvent()
    data object ErrorEvent : InfoEvent()
}