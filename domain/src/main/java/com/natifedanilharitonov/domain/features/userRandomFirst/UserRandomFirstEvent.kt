package com.natifedanilharitonov.domain.features.userRandomFirst

import com.natifedanilharitonov.core.UiEvent

sealed class UserRandomFirstEvent : UiEvent {
    data object GetRandomUserInfoEvent : UserRandomFirstEvent()

    data class RandomUserIsReceived(val user: UserResult) : UserRandomFirstEvent()

    data object ErrorEvent : UserRandomFirstEvent()
}
