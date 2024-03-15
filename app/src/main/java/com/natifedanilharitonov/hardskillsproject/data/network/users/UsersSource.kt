package com.natifedanilharitonov.hardskillsproject.data.network.users

import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser

interface UsersSource {
    suspend fun getUsers(): List<DomainUser>
}