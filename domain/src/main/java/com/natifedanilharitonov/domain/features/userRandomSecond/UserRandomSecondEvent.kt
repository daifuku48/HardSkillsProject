package com.natifedanilharitonov.domain.features.userRandomSecond

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult

sealed class UserRandomSecondEvent : UiEvent {
    data object GetRandomUserInfo : UserRandomSecondEvent()

    data class RandomUserInfoIsReceived(val userResult: UserResult) : UserRandomSecondEvent()

    data object ErrorEvent : UserRandomSecondEvent()
}
