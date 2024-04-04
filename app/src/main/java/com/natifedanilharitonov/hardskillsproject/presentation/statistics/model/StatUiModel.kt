package com.natifedanilharitonov.hardskillsproject.presentation.statistics.model

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.PersistentList

@Stable
interface StatUiModel {
    data object Pending : StatUiModel
    data class Model(val model: PersistentList<Pair<Float, Float>>) : StatUiModel
    data object Error : StatUiModel
}