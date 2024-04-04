package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.PersistentList

@Stable
interface DoubleStatUiModel {
    object Pending : DoubleStatUiModel
    data class Model(
        val modelLines: PersistentList<Pair<Float, Float>>,
        val modelColumns: PersistentList<Pair<Float, Float>>
    ) : DoubleStatUiModel

    object Error : DoubleStatUiModel
}