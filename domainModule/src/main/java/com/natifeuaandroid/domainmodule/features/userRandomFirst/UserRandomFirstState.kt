package com.natifeuaandroid.domainmodule.features.userRandomFirst

import com.natifeuaandroid.domainmodule.model.DomainUser

data class UserRandomFirstState(
    val userResult: DomainUser? = null,
    val isPending: Boolean = true,
)

