package com.natifedanilharitonov.domain.use_cases.main

interface StateText {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapPending(): T
        fun mapText(text: String): T
        fun mapError(): T
    }

    data object Pending : StateText {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPending()
        }
    }

    data class Text(val text: String) : StateText {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapText(text)
        }
    }

    data object ErrorText : StateText {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}