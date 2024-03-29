package com.natifedanilharitonov.hardskillsproject.presentation.activities.model

import com.natifedanilharitonov.domain.use_cases.main_activity.StartDestinationResult

class StartDestinationMapper : StartDestinationResult.Mapper<StartDestinationUiModel> {
    override fun mapToMainDestination(): StartDestinationUiModel {
        return StartDestinationUiModel.MainScreenDestination
    }

    override fun mapToLoginDestination(): StartDestinationUiModel {
        return StartDestinationUiModel.LoginScreenDestination
    }
}