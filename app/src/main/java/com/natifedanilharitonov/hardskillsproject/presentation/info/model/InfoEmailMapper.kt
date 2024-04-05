package com.natifedanilharitonov.hardskillsproject.presentation.info.model

import com.natifedanilharitonov.domain.features.info.model.InfoEmailResult

class InfoEmailMapper : InfoEmailResult.Mapper<InfoEmailUiState> {
    override fun mapPending(): InfoEmailUiState {
        return InfoEmailUiState.Pending
    }

    override fun mapSuccess(text: String): InfoEmailUiState {
        return InfoEmailUiState.Email(text)
    }

    override fun mapUnauthorized(): InfoEmailUiState {
        return InfoEmailUiState.Error
    }
}
