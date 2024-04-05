package com.natifedanilharitonov.domain.repository

interface MockTextRepository {
    suspend fun getText(): String?
}
