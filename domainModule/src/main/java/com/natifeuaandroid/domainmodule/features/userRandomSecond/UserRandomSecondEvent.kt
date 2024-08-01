package com.natifeuaandroid.domainmodule.features.userRandomSecond

import com.natifeuaandroid.domainmodule.model.DomainUser

sealed class UserRandomSecondEvent {
    data object GetRandomUserInfo : UserRandomSecondEvent()

    data class RandomUserInfoIsReceived(val userResult: DomainUser?) :
        UserRandomSecondEvent()

    data object RandomUserErrorEvent : UserRandomSecondEvent()
    data object ErrorEvent : UserRandomSecondEvent()
}
