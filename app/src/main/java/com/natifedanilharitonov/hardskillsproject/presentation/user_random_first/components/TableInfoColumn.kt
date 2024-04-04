package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UiName

@Composable
fun TableInfoColumn(name: UiName, email: String, gender: String, phone: String) {
    Column(
        Modifier
            .padding(16.dp)
    ) {
        UserRowInfo(
            title = stringResource(id = R.string.name), description = stringResource(
                id = R.string.full_name,
                name.title,
                name.first,
                name.last
            )
        )
        UserRowInfo(title = stringResource(R.string.email_text), description = email)
        UserRowInfo(title = stringResource(R.string.gender), description = gender)
        UserRowInfo(title = stringResource(R.string.phone_number), description = phone)
    }
}
