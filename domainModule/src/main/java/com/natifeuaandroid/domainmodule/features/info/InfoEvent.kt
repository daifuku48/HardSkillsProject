package com.natifeuaandroid.domainmodule.features.info

sealed class InfoEvent {
    data object GetUserInfoEvent : InfoEvent()

    data class UserDataEventIsReceived(
        val email: String,
    ) : InfoEvent()

    data object EmailErrorEvent : InfoEvent()

    data object ErrorEvent : InfoEvent()
}
