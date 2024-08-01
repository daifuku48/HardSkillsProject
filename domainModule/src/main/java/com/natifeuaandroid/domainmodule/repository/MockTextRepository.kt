package com.natifeuaandroid.domainmodule.repository

interface MockTextRepository {
    suspend fun getText(): String?
}
