package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model

import kotlinx.collections.immutable.PersistentList

interface DoubleStatUiModel {
    object Pending : DoubleStatUiModel
    data class Model(
        val modelLines: PersistentList<Pair<Float, Float>>,
        val modelColumns: PersistentList<Pair<Float, Float>>
    ) : DoubleStatUiModel

    object Error : DoubleStatUiModel
}