package com.natifedanilharitonov.hardskillsproject.data.repository.recourses

import com.natifedanilharitonov.hardskillsproject.data.source.info.ResourcesInfoSource
import com.natifedanilharitonov.hardskillsproject.domain.repository.RecoursesInfoRepository

class RecoursesInfoRepositoryImpl(
    private val resourcesInfoSource: ResourcesInfoSource
) : RecoursesInfoRepository {
    override fun getUnauthorizedText(): String {
        return resourcesInfoSource.getUnauthorizedText()
    }
}