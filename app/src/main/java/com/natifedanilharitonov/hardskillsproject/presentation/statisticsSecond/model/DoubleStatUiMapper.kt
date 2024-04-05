package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.model

import com.natifedanilharitonov.domain.features.statisticsSecond.DoubleStatModel
import kotlinx.collections.immutable.PersistentList

class DoubleStatUiMapper : DoubleStatModel.Mapper<DoubleStatUiModel> {
    override fun mapPending(): DoubleStatUiModel {
        return DoubleStatUiModel.Pending
    }

    override fun mapModel(
        modelLines: PersistentList<Pair<Float, Float>>,
        modelColumns: PersistentList<Pair<Float, Float>>,
    ): DoubleStatUiModel {
        return DoubleStatUiModel.Model(modelLines, modelColumns)
    }

    override fun mapError(): DoubleStatUiModel {
        return DoubleStatUiModel.Error
    }
}