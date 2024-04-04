package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.info.InfoEvent
import com.natifedanilharitonov.domain.features.info.InfoState
import com.natifedanilharitonov.domain.features.info.model.InfoEmailResult
import com.natifedanilharitonov.hardskillsproject.presentation.info.model.InfoEmailUiState

class InfoReducer(
    private val infoEmailMapper: InfoEmailResult.Mapper<InfoEmailUiState>
) : Reducer<InfoState, InfoEvent, InfoUiState> {
    override fun reduce(state: InfoState, event: InfoEvent): InfoState {
        return when (event) {
            is InfoEvent.ErrorEvent -> state
            is InfoEvent.GetUserInfoEvent -> state
            is InfoEvent.UserDataEventIsReceived -> state.copy(email = event.email)
        }
    }

    override fun mapToUiModel(state: InfoState): InfoUiState {
        return InfoUiState(
            email = state.email.map(infoEmailMapper)
        )
    }
}