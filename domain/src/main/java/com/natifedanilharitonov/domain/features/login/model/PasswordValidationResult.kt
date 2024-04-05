package com.natifedanilharitonov.domain.features.login.model

interface PasswordValidationResult {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapValid(): T

        fun mapError(): T
    }

    data object ValidPassword : PasswordValidationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapValid()
        }
    }

    data object ErrorPassword : PasswordValidationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}
