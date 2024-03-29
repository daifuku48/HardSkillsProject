package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import com.natifedanilharitonov.domain.model.DomainName

data class UiName(
    val title: String,
    val first: String,
    val last: String
)

fun DomainName.toUi(): UiName {
    return UiName(
        title = title,
        first = first,
        last = last
    )
}