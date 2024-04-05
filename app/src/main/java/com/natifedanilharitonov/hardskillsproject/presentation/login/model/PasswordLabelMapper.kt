package com.natifedanilharitonov.hardskillsproject.presentation.login.model

import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult

class PasswordLabelMapper : PasswordValidationResult.Mapper<PasswordLabelState> {
    override fun mapValid(): PasswordLabelState {
        return PasswordLabelState.ValidPassword
    }

    override fun mapError(): PasswordLabelState {
        return PasswordLabelState.ErrorPassword
    }
}
