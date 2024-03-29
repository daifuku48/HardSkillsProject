package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.info.InfoEvent
import com.natifedanilharitonov.domain.use_cases.info.InfoState
import com.natifedanilharitonov.hardskillsproject.presentation.info.model.InfoEmailMapper

class InfoReducer(
    private val infoEmailMapper: InfoEmailMapper
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