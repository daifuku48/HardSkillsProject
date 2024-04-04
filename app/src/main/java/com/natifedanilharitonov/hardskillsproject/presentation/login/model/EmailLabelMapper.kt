package com.natifedanilharitonov.hardskillsproject.presentation.login.model


import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult

class EmailLabelMapper : EmailValidationResult.Mapper<EmailLabelState> {
    override fun mapValid(): EmailLabelState {
        return EmailLabelState.ValidEmailLabel
    }

    override fun mapError(): EmailLabelState {
        return EmailLabelState.ErrorEmailLabel
    }
}