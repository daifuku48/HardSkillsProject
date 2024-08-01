package com.natifeuaandroid.domainmodule.features.userRandomSecond

import com.natifeuaandroid.domainmodule.model.DomainUser

data class UserRandomSecondState(
    val userResult: DomainUser? = null,
    val showError: Boolean = false,
    val isPending: Boolean = true,
)
