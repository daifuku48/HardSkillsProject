package com.natifedanilharitonov.domain.use_cases.info

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.info.model.InfoEmailResult

data class InfoState(
    val email: InfoEmailResult = InfoEmailResult.PendingEmail
) : UiState