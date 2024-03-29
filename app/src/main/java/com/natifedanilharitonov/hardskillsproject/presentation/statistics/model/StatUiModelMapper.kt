package com.natifedanilharitonov.hardskillsproject.presentation.statistics.model

import com.natifedanilharitonov.domain.use_cases.statistics.StatModel
import kotlinx.collections.immutable.PersistentList

class StatUiModelMapper : StatModel.Mapper<StatUiModel> {
    override fun mapPending(): StatUiModel {
        return StatUiModel.Pending
    }

    override fun mapModel(model: PersistentList<Pair<Float, Float>>): StatUiModel {
        return StatUiModel.Model(model)
    }

    override fun mapError(): StatUiModel {
        return StatUiModel.Error
    }
}