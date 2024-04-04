package com.natifedanilharitonov.domain.features.main_activity

interface StartDestinationResult {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapToMainDestination(): T
        fun mapToLoginDestination(): T
    }

    data object MainScreenDestination : StartDestinationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapToMainDestination()
        }
    }

    data object LoginScreenDestination : StartDestinationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapToLoginDestination()
        }
    }
}