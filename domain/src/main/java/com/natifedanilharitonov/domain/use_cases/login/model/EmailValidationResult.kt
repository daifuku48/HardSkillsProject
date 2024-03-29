package com.natifedanilharitonov.domain.use_cases.login.model

interface EmailValidationResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapValid(): T
        fun mapError(): T
    }

    data object ValidEmail : EmailValidationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapValid()
        }
    }

    data object ErrorEmail : EmailValidationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}