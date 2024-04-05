package com.natifedanilharitonov.hardskillsproject.presentation.infoFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.infoFirst.InfoFirstEvent
import com.natifedanilharitonov.domain.features.infoFirst.InfoFirstState
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class InfoFirstReducer(
    private val mapper: StateText.Mapper<StateTextUiModel>,
) : Reducer<InfoFirstState, InfoFirstEvent, InfoFirstUiModel> {
    override fun reduce(
        state: InfoFirstState,
        event: InfoFirstEvent,
    ): InfoFirstState {
        return when (event) {
            is InfoFirstEvent.ErrorEvent -> state
            is InfoFirstEvent.GetTextEvent -> state.copy(text = StateText.Pending)
            is InfoFirstEvent.TextReceivedEvent -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: InfoFirstState): InfoFirstUiModel {
        return InfoFirstUiModel(
            text = state.text.map(mapper),
        )
    }
}
