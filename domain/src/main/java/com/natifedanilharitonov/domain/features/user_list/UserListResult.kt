package com.natifedanilharitonov.domain.features.user_list

import com.natifedanilharitonov.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

interface UserListResult {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapPending(): T
        fun mapList(userList: PersistentList<DomainUser>): T
        fun mapError(): T
    }

    data object Pending : UserListResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPending()
        }
    }

    data class List(val userList: PersistentList<DomainUser>) : UserListResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapList(userList)
        }
    }

    data object ErrorList : UserListResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}