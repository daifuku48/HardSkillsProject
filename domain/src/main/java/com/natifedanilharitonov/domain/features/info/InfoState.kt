package com.natifedanilharitonov.domain.features.info

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.info.model.InfoEmailResult

data class InfoState(
    val email: InfoEmailResult = InfoEmailResult.PendingEmail,
) : UiState
