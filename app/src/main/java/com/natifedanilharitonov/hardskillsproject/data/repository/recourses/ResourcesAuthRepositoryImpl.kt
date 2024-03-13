package com.natifedanilharitonov.hardskillsproject.data.repository.recourses

import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesAuthSource

class ResourcesAuthRepositoryImpl(
    private val resourcesSource: ResourcesAuthSource
) : ResourcesAuthRepository {
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