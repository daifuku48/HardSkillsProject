package com.natifedanilharitonov.hardskillsproject.data.source.info

import android.content.Context
import com.natifedanilharitonov.hardskillsproject.R

class ResourcesInfoSourceImpl(private val context: Context) : ResourcesInfoSource {
    override fun getUnauthorizedText(): String {
        return context.getString(R.string.unauthorized_user)
    }
}