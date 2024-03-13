package com.natifedanilharitonov.hardskillsproject.data.repository.recourses

import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesInfoSource

class RecoursesInfoRepositoryImpl(
    private val resourcesInfoSource: ResourcesInfoSource
) : RecoursesInfoRepository {
    override fun getUnauthorizedText(): String {
        return resourcesInfoSource.getUnauthorizedText()
    }
}