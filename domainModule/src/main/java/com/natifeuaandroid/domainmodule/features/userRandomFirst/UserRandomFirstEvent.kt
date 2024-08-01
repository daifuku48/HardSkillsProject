package com.natifeuaandroid.domainmodule.features.userRandomFirst

import com.natifeuaandroid.domainmodule.model.DomainUser


sealed class UserRandomFirstEvent {
    data object GetRandomUserInfoEvent : UserRandomFirstEvent()

    data class RandomUserIsReceived(val user: DomainUser?) : UserRandomFirstEvent()
    data object ShowUserErrorEvent : UserRandomFirstEvent()
    data object ErrorEvent : UserRandomFirstEvent()
}
