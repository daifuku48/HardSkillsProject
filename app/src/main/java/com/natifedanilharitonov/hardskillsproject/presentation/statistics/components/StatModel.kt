package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import kotlinx.collections.immutable.PersistentList

sealed class StatModel {
    data object Pending : StatModel()
    data class Model(val model: PersistentList<Pair<Float, Float>>) : StatModel()
    data object Error : StatModel()
}