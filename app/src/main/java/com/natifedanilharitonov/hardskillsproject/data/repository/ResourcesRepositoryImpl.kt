package com.natifedanilharitonov.hardskillsproject.data.repository

import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesSource

class ResourcesRepositoryImpl(
    private val resourcesSource: ResourcesSource
) : ResourcesRepository {
    override fun getEmailLabel(): String {
        return resourcesSource.getEmailLabel()
    }

    override fun getEmailErrorLabel(): String {
        return resourcesSource.getEmailErrorLabel()
    }

    override fun getPasswordLabel(): String {
        return resourcesSource.getPasswordLabel()
    }

    override fun getPasswordErrorLabel(): String {
        return resourcesSource.getPasswordErrorLabel()
    }

    override fun getNicknameLabel(): String {
        return resourcesSource.getNicknameLabel()
    }

    override fun getNicknameErrorLabel(): String {
        return resourcesSource.getNicknameErrorLabel()
    }
}