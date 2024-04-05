package com.natifedanilharitonov.hardskillsproject.presentation.main.model

import com.natifedanilharitonov.domain.features.main.StateText

class StateTextUiMapper : StateText.Mapper<StateTextUiModel> {
    override fun mapPending(): StateTextUiModel {
        return StateTextUiModel.Pending
    }

    override fun mapText(text: String): StateTextUiModel {
        return StateTextUiModel.Text(text)
    }

    override fun mapError(): StateTextUiModel {
        return StateTextUiModel.ErrorText
    }
}
