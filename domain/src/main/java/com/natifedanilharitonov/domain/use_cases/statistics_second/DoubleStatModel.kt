package com.natifedanilharitonov.domain.use_cases.statistics_second

import kotlinx.collections.immutable.PersistentList

interface DoubleStatModel {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {
        fun mapPending(): T
        fun mapModel(
            modelLines: PersistentList<Pair<Float, Float>>,
            modelColumns: PersistentList<Pair<Float, Float>>
        ): T

        fun mapError(): T
    }

    data object Pending : DoubleStatModel {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPending()
        }
    }

    data class Model(
        val modelLines: PersistentList<Pair<Float, Float>>,
        val modelColumns: PersistentList<Pair<Float, Float>>
    ) : DoubleStatModel {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapModel(modelLines, modelColumns)
        }
    }

    data object Error : DoubleStatModel {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError()
        }
    }
}