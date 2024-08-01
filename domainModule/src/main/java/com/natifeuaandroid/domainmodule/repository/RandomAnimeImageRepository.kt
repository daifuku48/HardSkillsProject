package com.natifeuaandroid.domainmodule.repository

interface RandomAnimeImageRepository {
    suspend fun getImage(): String?
}
