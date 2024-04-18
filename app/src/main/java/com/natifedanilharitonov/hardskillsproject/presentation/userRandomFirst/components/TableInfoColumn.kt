package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiName
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.EMAIL_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.GENDER_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.NAME_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PHONE_NUMBER_TAG

@Composable
fun TableInfoColumn(
    name: UiName,
    email: String,
    gender: String,
    phone: String,
) {
    Column(
        Modifier
            .padding(16.dp),
    ) {
        UserRowInfo(
            title = stringResource(id = R.string.name),
            description =
                stringResource(
                    id = R.string.full_name,
                    name.title,
                    name.first,
                    name.last,
                ),
            modifier = Modifier.testTag(NAME_TAG),
        )
        UserRowInfo(
            title = stringResource(R.string.email_text),
            description = email,
            modifier = Modifier.testTag(EMAIL_TAG),
        )
        UserRowInfo(
            title = stringResource(R.string.gender),
            description = gender,
            modifier = Modifier.testTag(GENDER_TAG),
        )
        UserRowInfo(
            title = stringResource(R.string.phone_number),
            description = phone,
            modifier = Modifier.testTag(PHONE_NUMBER_TAG),
        )
    }
}
