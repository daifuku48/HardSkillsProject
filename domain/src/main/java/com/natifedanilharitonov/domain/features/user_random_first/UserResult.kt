package com.natifedanilharitonov.domain.features.user_random_first

import com.natifedanilharitonov.domain.model.DomainUser

interface UserResult {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {
        fun mapPending(): T
        fun mapModel(
            user: DomainUser
        ): T

        fun mapError(): T
    }

    data object Pending : UserResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPending()
        }
    }

    data class Model(
        val user: DomainUser
    ) : UserResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapModel(user)
        }
    }

    data object Error : UserResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}