package com.natifedanilharitonov.domain.use_cases.info.model

interface InfoEmailResult {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapPending(): T
        fun mapSuccess(text: String): T
        fun mapUnauthorized(): T
    }

    data object PendingEmail : InfoEmailResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPending()
        }
    }

    data class Email(val text: String) : InfoEmailResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(text)
        }
    }

    data object ErrorEmail : InfoEmailResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapUnauthorized()
        }
    }
}