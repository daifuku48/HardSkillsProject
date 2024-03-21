package com.natifedanilharitonov.hardskillsproject.domain.repository

interface MockTextRepository {
    suspend fun getText(): String?
}