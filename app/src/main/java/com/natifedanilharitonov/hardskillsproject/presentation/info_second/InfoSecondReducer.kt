package com.natifedanilharitonov.hardskillsproject.presentation.info_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.info_second.InfoSecondEvent
import com.natifedanilharitonov.domain.features.info_second.InfoSecondState
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class InfoSecondReducer(
    private val mapper: StateText.Mapper<StateTextUiModel>
) : Reducer<InfoSecondState, InfoSecondEvent, InfoSecondUiModel> {
    override fun reduce(state: InfoSecondState, event: InfoSecondEvent): InfoSecondState {
        return when (event) {
            is InfoSecondEvent.ErrorEvent -> state
            is InfoSecondEvent.GetTextEvent -> state.copy(text = StateText.Pending)
            is InfoSecondEvent.TextReceivedEvent -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: InfoSecondState): InfoSecondUiModel {
        return InfoSecondUiModel(
            text = state.text.map(mapper)
        )
    }
}