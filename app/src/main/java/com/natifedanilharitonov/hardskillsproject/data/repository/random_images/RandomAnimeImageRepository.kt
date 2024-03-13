package com.natifedanilharitonov.hardskillsproject.data.repository.random_images

interface RandomAnimeImageRepository {
    suspend fun getImage() : String
}