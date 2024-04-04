package com.natifedanilharitonov.domain.features.user_random_second

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.user_random_first.UserResult

sealed class UserRandomSecondEvent : UiEvent {
    data object GetRandomUserInfo : UserRandomSecondEvent()
    data class RandomUserInfoIsReceived(val userResult: UserResult) : UserRandomSecondEvent()
    data object ErrorEvent : UserRandomSecondEvent()
}