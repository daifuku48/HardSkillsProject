package com.natifedanilharitonov.domain.features.statistics

import kotlinx.collections.immutable.PersistentList

interface StatModel {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {
        fun mapPending(): T
        fun mapModel(model: PersistentList<Pair<Float, Float>>): T
        fun mapError(): T
    }

    data object Pending : StatModel {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPending()
        }
    }

    data class Model(val model: PersistentList<Pair<Float, Float>>) : StatModel {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapModel(model)
        }
    }

    data object Error : StatModel {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}