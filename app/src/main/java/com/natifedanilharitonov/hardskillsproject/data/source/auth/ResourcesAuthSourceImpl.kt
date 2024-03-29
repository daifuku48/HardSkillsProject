package com.natifedanilharitonov.hardskillsproject.data.source.auth

import android.content.Context
import com.natifedanilharitonov.hardskillsproject.R

class ResourcesAuthSourceImpl(
    private val context: Context
) : ResourcesAuthSource {
    override fun getNicknameLabel(): String {
        return context.getString(R.string.nickname_label)
    }

    override fun getNicknameErrorLabel(): String {
        return context.getString(R.string.nickname_error_label)
    }

    override fun getEmailLabel(): String {
        return context.getString(R.string.email_label)
    }

    override fun getEmailErrorLabel(): String {
        return context.getString(R.string.email_error_label)
    }

    override fun getPasswordLabel(): String {
        return context.getString(R.string.password_label)
    }

    override fun getPasswordErrorLabel(): String {
        return context.getString(R.string.password_error_label)
    }
}