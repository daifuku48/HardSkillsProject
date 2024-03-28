package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components

import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel
import kotlinx.collections.immutable.PersistentList

sealed class DoubleStatModel {
    data object Pending : DoubleStatModel()
    data class Model(
        val modelLines: PersistentList<Pair<Float, Float>>,
        val modelColumns: PersistentList<Pair<Float, Float>>
    ) : DoubleStatModel()

    data object Error : DoubleStatModel()
}